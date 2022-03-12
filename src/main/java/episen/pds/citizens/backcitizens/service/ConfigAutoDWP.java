package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.CitizensBackendApplication;
import episen.pds.citizens.backcitizens.model.EquipmentAndData;
import episen.pds.citizens.backcitizens.model.Room;
import episen.pds.citizens.backcitizens.repository.ConditionsRepo;
import episen.pds.citizens.backcitizens.repository.EquipmentAndDataRepo;
import episen.pds.citizens.backcitizens.repository.MeasureRepo;
import episen.pds.citizens.backcitizens.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.function.Consumer;
import java.util.logging.Logger;

@Service
public class ConfigAutoDWP implements Runnable {

    @Autowired
    UseMonitorService useMonitorService;
    @Autowired
    MeasureRepo measureRepo;

    @Autowired
    ConditionsRepo conditionsRepo;
    @Autowired
    RoomRepo roomRepo;
    @Autowired
    EquipmentAndDataRepo equipmentAndDataRepo;

    private static final Logger logger = Logger.getLogger(CitizensBackendApplication.class.getName());


    @Override
    public void run() {
        configAuto();
    }

    public void configAuto() {
        while (true) {
            Iterable<Room> rooms = roomRepo.findAllBusinessRoom();
            rooms.forEach(new Consumer<Room>() {
                @Override
                public void accept(Room room) {
                    int difTemp = measureRepo.getTempStatInRoom(room.getId_room()).getValue() - conditionsRepo.findLastConditionsByRoom(room.getId_room()).getTemperature();
                    int difLum = measureRepo.getLightStatInRoom(room.getId_room()).getValue() - conditionsRepo.findLastConditionsByRoom(room.getId_room()).getLuminosity();
                    Timestamp current_date = measureRepo.getTimestamp();
                    configLightAuto(room.getId_room(), difLum, current_date);
                    configTempAuto(room.getId_room(), difTemp, current_date);
                }
            });
        }
    }

    public void configLightAuto(int id_room, int difLum, Timestamp current_date) {
        Iterable<EquipmentAndData> equipments = equipmentAndDataRepo.getAutoEquipment_DataByIdRoom(id_room);
        if (difLum < 0) {
            equipments.forEach(new Consumer<EquipmentAndData>() {
                @Override
                public void accept(EquipmentAndData equipment) {
                    if (current_date.getHours() < 18 && current_date.getHours() > 8) {
                        if (equipment.getType().equals("store")) {
                            useMonitorService.setEquipmentOn(equipment.getId_equipment());
                            if (equipment.getValue()+1 <= 5)
                                useMonitorService.setEquipmentOneUp(equipment.getId_equipment());
                        }
                    } else {
                        if (equipment.getType().equals("lampe") && equipment.getValue() < 5)
                            useMonitorService.setEquipmentOneUp(equipment.getId_equipment());
                    }
                }
            });
        }
        else {
            equipments.forEach(new Consumer<EquipmentAndData>() {
                @Override
                public void accept(EquipmentAndData equipment) {
                    if (equipment.getType().equals("store")) {
                        useMonitorService.setEquipmentOff(equipment.getId_equipment());
                        useMonitorService.setEquipmentValue(equipment.getId_equipment(), 0);
                    }
                    if (equipment.getType().equals("lampe")) {
                        useMonitorService.setEquipmentOneDown(equipment.getId_equipment());
                        if (equipment.getValue() == 1)
                            useMonitorService.setEquipmentOff(equipment.getId_equipment());
                    }
                }
            });
        }
    }

    public void configTempAuto(int id_room, int difTemp, Timestamp current_date) {
        Iterable<EquipmentAndData> equipments = equipmentAndDataRepo.getAutoEquipment_DataByIdRoom(id_room);
        if (difTemp < 0) {
            equipments.forEach(new Consumer<EquipmentAndData>() {
                @Override
                public void accept(EquipmentAndData equipment) {
                    if (equipment.getType().equals("fenêtre")) {
                        useMonitorService.setEquipmentOff(equipment.getId_equipment());
                        useMonitorService.setEquipmentValue(equipment.getId_equipment(), 0);
                    }
                    if (equipment.getType().equals("climatisation")) {
                        useMonitorService.setEquipmentOneDown(equipment.getId_equipment());
                        if (equipment.getValue() == 1)
                            useMonitorService.setEquipmentOff(equipment.getId_equipment());
                    }
                }
            });
        }
        else {
            equipments.forEach(new Consumer<EquipmentAndData>() {
                @Override
                public void accept(EquipmentAndData equipment) {
                    if (equipment.getType().equals("fenêtre")) {
                        useMonitorService.setEquipmentOn(equipment.getId_equipment());
                        if (equipment.getValue() < 5)
                            useMonitorService.setEquipmentOneUp(equipment.getId_equipment());
                    }
                    if (equipment.getType().equals("radiateur")) {
                        useMonitorService.setEquipmentOneDown(equipment.getId_equipment());
                        if (equipment.getValue() == 1)
                            useMonitorService.setEquipmentOff(equipment.getId_equipment());
                    }
                }
            });
        }
        difTemp = measureRepo.getTempStatInRoom(id_room).getValue() - conditionsRepo.findLastConditionsByRoom(id_room).getTemperature();
        if (difTemp < 0) {
            equipments.forEach(new Consumer<EquipmentAndData>() {
                @Override
                public void accept(EquipmentAndData equipment) {
                    if (equipment.getType().equals("radiateur") && equipment.getValue() < 5)
                        useMonitorService.setEquipmentOneUp(equipment.getId_equipment());
                }
            });
        }
        else {
            equipments.forEach(new Consumer<EquipmentAndData>() {
                @Override
                public void accept(EquipmentAndData equipment) {
                    if (equipment.getType().equals("climatisation") && equipment.getValue() < 5)
                        useMonitorService.setEquipmentOneUp(equipment.getId_equipment());
                }
            });
        }

    }
}
