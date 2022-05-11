package episen.pds.citizens.backcitizens.service;

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
public class ConfigTempAutoDWP implements Runnable {

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
    int id_user;

    private static final Logger logger = Logger.getLogger(ConfigTempAutoDWP.class.getName());

    public void ConfigLightAutoDWP(int id_u) {
        id_user = id_u;
    }
    public void configAuto()  {
        while (true) {
            Iterable<Room> rooms = roomRepo.findAllBusinessRoom(id_user);
            rooms.forEach(room -> {
                try {
                    int difTemp = measureRepo.getTempStatInRoom(room.getId_room()).getValue() - conditionsRepo.findLastConditionsByRoom(room.getId_room()).getTemperature();
                    Timestamp current_date = measureRepo.getTimestamp();
                    //             if (current_date.getHours()<8 || current_date.getHours()>22) {
                    //                 useMonitorService.setAllEquipmentsOff(room.getId_room());
                    //             } else {
                    while (difTemp > 3 || difTemp < -3) {
                        configTempAuto(room.getId_room(), difTemp);
                        difTemp = measureRepo.getTempStatInRoom(room.getId_room()).getValue() - conditionsRepo.findLastConditionsByRoom(room.getId_room()).getTemperature();
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

    public void configTempAuto(int id_room, int difTemp) {
        Iterable<EquipmentAndData> equipments = equipmentAndDataRepo.getAutoEquipment_DataByIdRoom(id_room);
        if (difTemp < 0) {
            equipments.forEach(equipment -> {
                if (equipment.getType().equals("fenêtre")) {
                    useMonitorService.setEquipmentOff(equipment.getId_equipment());
                    useMonitorService.setEquipmentValue(equipment.getId_equipment(), 0);
                }
                if (equipment.getType().equals("climatisation") && equipment.getValue() > 0) {
                    useMonitorService.setEquipmentOneDown(equipment.getId_equipment());
                    logger.info("-1 on climatisation for " + id_room);
                    //   if (equipment.getValue() == 1)
                    //       useMonitorService.setEquipmentOff(equipment.getId_equipment());
                }
                if (equipment.getType().equals("radiateur") && equipment.getValue() < 5) {
                    useMonitorService.setEquipmentOneUp(equipment.getId_equipment());
                    logger.info("-1 on radiator for " + id_room);
                    //  if (equipment.getValue() == 1)
                    //      useMonitorService.setEquipmentOff(equipment.getId_equipment());
                }
            });
        }
        else {
            equipments.forEach(equipment -> {
                if (equipment.getType().equals("fenêtre") && equipment.getValue() < 5) {
                    useMonitorService.setEquipmentOn(equipment.getId_equipment());
                    useMonitorService.setEquipmentOneUp(equipment.getId_equipment());
                }
                if (equipment.getType().equals("radiateur") && equipment.getValue() > 0) {
                    useMonitorService.setEquipmentOneDown(equipment.getId_equipment());
                    logger.info("-1 on radiator for " + id_room);
                    //  if (equipment.getValue() == 1)
                    //      useMonitorService.setEquipmentOff(equipment.getId_equipment());
                }
                if (equipment.getType().equals("climatisation") && equipment.getValue() < 5) {
                    useMonitorService.setEquipmentOneUp(equipment.getId_equipment());
                    logger.info("-1 on climatisation for " + id_room);
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
