package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.*;
import episen.pds.citizens.backcitizens.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.logging.Logger;

@Service
public class UseMonitorService {

    @Autowired
    private DWP_EquipmentRepo equipmentRepo;

    @Autowired
    private ConsumptionRepo consumptionRepo;

    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private ConditionsRepo conditionRepo;

    @Autowired
    private MeasureRepo measureRepo;

    @Autowired
    private EquipmentDataRepo equipmentDataRepo;

    @Autowired
    private EquipmentAndDataRepo equipmentAndDataRepo;

    private static final Logger logger = Logger.getLogger(UseMonitorService.class.getName());

    // ROOMS

    public Optional<Room> getRoomById(int id_room) {
        return roomRepo.findById(id_room);
    }
    public void saveRoom(Room room) {
        roomRepo.save(room);
    }

    // EQUIPMENTS

    public Optional<DWP_Equipment> getEquipmentById(int id_equipment) {
        return equipmentRepo.findById(id_equipment);
    }
    public Iterable<DWP_Equipment> getAllEquipments() {
        return equipmentRepo.findAll();
    }
    public void saveEquipment(DWP_Equipment DWPEquipment) {
        equipmentRepo.save(DWPEquipment);
    }

    // CONSUMPTION

    public Iterable<Consumption> getAllConsumption() {
        return consumptionRepo.findAll();
    }

    public Iterable<Consumption> getConsumptionByBuilding(int id_building) {

        return consumptionRepo.findConsumptionByBuilding(id_building);
    }
    public Iterable<Consumption> getConsumptionByRoom(int id_room) {
        return consumptionRepo.findConsumptionByBuilding(id_room);
    }

    /*public Iterable<RoomsWithConsumption> getRoomsWithConsumption() {
        return roomRepo.findRoomsWithConsumption();
    }
 */
    public Iterable<DWP_Equipment> getEquipmentByRoom(int id_room) {
        return  equipmentRepo.findEquipmentByRoom(id_room);
    }

    public Iterable<DWP_Equipment> findEquipmentOrderByRoom() {
        return  equipmentRepo.findEquipmentOrderByRoom();
    }

    public synchronized void setEquipmentValue(int id_equipment, double value) {
        equipmentDataRepo.setEquipmentValue(id_equipment, value);
    }

    public void setEquipmentAuto(int id_equipment) {
        equipmentDataRepo.setEquipmentAuto(id_equipment);
    }

    public synchronized void setEquipmentManu(int id_equipment) {
        equipmentDataRepo.setEquipmentManu(id_equipment);
    }

    public synchronized void setEquipmentOff(int id_equipment) {
        equipmentDataRepo.setEquipmentOff(id_equipment);
    }

    public synchronized void setEquipmentOn(int id_equipment) {
        equipmentDataRepo.setEquipmentOn(id_equipment);
    }

    public Conditions getLastBestConditions(int id_room) {
        return conditionRepo.findLastConditionsByRoom(id_room);
    }

    public Measure getLastLightMeasure(int id_room) {
        return measureRepo.getLightStatInRoom(id_room);
    }

    public Measure getLastTempMeasure(int id_room) {
        return measureRepo.getTempStatInRoom(id_room);
    }

    public void autoAdjustOneEquipment(int id_equipment) {
        Room current_room = roomRepo.findRoomByEquipment(id_equipment);
        Measure current_light_conditions = measureRepo.getLightStatInRoom(current_room.getId_room());
        Measure current_temp_conditions = measureRepo.getLightStatInRoom(current_room.getId_room());
        DWP_Equipment current_DWP_equipment = equipmentRepo.findEquipmentById(id_equipment);
        Equipment_Data current_equipment_data = equipmentDataRepo.findEquipment_DataById(id_equipment);
        if (current_DWP_equipment.getType().equals("radiateur") || current_DWP_equipment.getType().equals("fenêtre") || current_DWP_equipment.getType().equals("climatisation"))
            this.autoAdjustTemperatureOneEquipment(current_DWP_equipment, current_temp_conditions, current_room);

        if (current_DWP_equipment.getType().equals("store") || current_DWP_equipment.getType().equals("lampe"))
            this.autoAdjustLuminosityOneEquipment(current_DWP_equipment, current_light_conditions, current_room);

    }

    private void autoAdjustLuminosityOneEquipment(DWP_Equipment current_DWP_equipment, Measure current_conditions, Room current_room) {
        double best_luminosity = getLastBestConditions(current_room.getId_room()).getLuminosity();
        while (current_conditions.getValue()<= best_luminosity) {
            setEquipmentOn(current_DWP_equipment.getId_equipment());
            current_conditions = measureRepo.getLightStatInRoom(current_room.getId_room());
        }
        while (current_conditions.getValue()> best_luminosity+50) {
            setEquipmentOneDown(current_DWP_equipment.getId_equipment());
            current_conditions = measureRepo.getLightStatInRoom(current_room.getId_room());
        }
    }

    public synchronized void setEquipmentOneUp(int id_equipment) {
        equipmentDataRepo.setEquipmentOneUp(id_equipment);
    }

    private void autoAdjustTemperatureOneEquipment(DWP_Equipment current_DWP_equipment, Measure current_conditions, Room current_room) {
        double best_temperature = getLastBestConditions(current_room.getId_room()).getTemperature();
        while (current_conditions.getValue()<= best_temperature) {
            if (current_DWP_equipment.getType().equals("fenêtre"))
                equipmentDataRepo.setEquipmentOff(current_DWP_equipment.getId_equipment());
            else if (current_DWP_equipment.getType().equals("climatisation"))
                setEquipmentOneDown(current_DWP_equipment.getId_equipment());
            else
                setEquipmentOneUp(current_DWP_equipment.getId_equipment());
            current_conditions = measureRepo.getTempStatInRoom(current_room.getId_room());
            logger.info("new measures : " + current_conditions);
        }
        while (current_conditions.getValue()> best_temperature+5) {
            if (current_DWP_equipment.getType().equals("fenêtre"))
                equipmentDataRepo.setEquipmentOn(current_DWP_equipment.getId_equipment());
            else if (current_DWP_equipment.getType().equals("climatisation"))
                setEquipmentOneUp(current_DWP_equipment.getId_equipment());
            else
                setEquipmentOneDown(current_DWP_equipment.getId_equipment());
            current_conditions = measureRepo.getTempStatInRoom(current_room.getId_room());
        }
    }

    public synchronized void  setEquipmentOneDown(int id_equipment) {
        equipmentDataRepo.setEquipmentOneDown(id_equipment);
    }

    public void setBestConditions(Conditions best_conditions) {
        conditionRepo.save(best_conditions);
    }


    public Iterable<EquipmentAndData> getEquipmentAndDataByRoom(int id_room) {
        return equipmentAndDataRepo.getEquipment_DataByIdRoom(id_room);
    }

    public Iterable<Room> findAllBusinessRoom() {
        return roomRepo.findAllBusinessRoom();
    }

    public synchronized void setAllEquipmentsOff(int id_room) {
        equipmentDataRepo.setAllEquipmentsOff(id_room);
    }
}
