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

import java.sql.Timestamp;
import java.util.logging.Logger;

@Service
public class ConfigLightAutoDWP implements Runnable {

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


    private static final Logger logger = Logger.getLogger(ConfigLightAutoDWP.class.getName());

    public void configAuto()  {
        while (true) {
            Iterable<Room> rooms = roomRepo.findAllBusinessRoom();
            rooms.forEach(room -> {
                try {
                    int difLum = measureRepo.getLightStatInRoom(room.getId_room()).getValue() - conditionsRepo.findLastConditionsByRoom(room.getId_room()).getLuminosity();

                    Timestamp current_date = measureRepo.getTimestamp();
                    //             if (current_date.getHours()<8 || current_date.getHours()>22) {
                    //                 useMonitorService.setAllEquipmentsOff(room.getId_room());
                    //             } else {
                    while (difLum > 10 || difLum < -10) {
                        configLightAuto(room.getId_room(), difLum, current_date);
                        difLum = measureRepo.getLightStatInRoom(room.getId_room()).getValue() - conditionsRepo.findLastConditionsByRoom(room.getId_room()).getLuminosity();
                    }
                } catch (Exception e) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }
    }

    public void configLightAuto(int id_room, int difLum, Timestamp current_date) {
        Iterable<EquipmentAndData> equipments = equipmentAndDataRepo.getAutoEquipment_DataByIdRoom(id_room);
        if (difLum < 0) {
            equipments.forEach(equipment -> {
                if (equipment.getValue() < 5 && equipment.getType().equals("store")) {
                    useMonitorService.setEquipmentOn(equipment.getId_equipment());
                    logger.info("+1 on store for " + id_room);
                    useMonitorService.setEquipmentOneUp(equipment.getId_equipment());
                } else if (equipment.getType().equals("lampe") && equipment.getValue() < 5) {
                    logger.info("+1 on lampe for " + id_room);
                    useMonitorService.setEquipmentOneUp(equipment.getId_equipment());
                }
            });
        }
        else {
            equipments.forEach(equipment -> {
                if (equipment.getType().equals("store") && equipment.getValue() > 0) {
                    useMonitorService.setEquipmentOff(equipment.getId_equipment());
                    useMonitorService.setEquipmentValue(equipment.getId_equipment(), 0);
                } else if (equipment.getType().equals("lampe")) {
                    useMonitorService.setEquipmentOneDown(equipment.getId_equipment());
                    logger.info("-1 on lampe for " + id_room);
                    //   if (equipment.getValue() == 1)
                    //       useMonitorService.setEquipmentOff(equipment.getId_equipment());
                }
            });
        }
    }

    @Override
    public void run() {
        configAuto();
    }
}
