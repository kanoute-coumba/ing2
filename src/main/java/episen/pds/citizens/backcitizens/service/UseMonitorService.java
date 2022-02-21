package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.*;
import episen.pds.citizens.backcitizens.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UseMonitorService {

    @Autowired
    private EquipmentRepo equipmentRepo;

    @Autowired
    private ConsumptionRepo consumptionRepo;

    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private ConditionRepo conditionRepo;

    // ROOMS

    public Optional<Room> getRoomById(int id_room) {
        return roomRepo.findById(id_room);
    }
    public Iterable<Room> getAllRooms() {
        return roomRepo.findAll();
    }
    public void saveRoom(Room room) {
        roomRepo.save(room);
    }

    // EQUIPMENTS

    public Optional<Equipment> getEquipmentById(int id_equipment) {
        return equipmentRepo.findById(id_equipment);
    }
    public Iterable<Equipment> getAllEquipments() {
        return equipmentRepo.findAll();
    }
    public void saveEquipment(Equipment equipment) {
        equipmentRepo.save(equipment);
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
    public Iterable<Equipment> getEquipmentByRoom(int id_room) {
        return  equipmentRepo.findEquipmentByRoom(id_room);
    }

    public Iterable<Equipment> findEquipmentOrderByRoom() {
        return  equipmentRepo.findEquipmentOrderByRoom();
    }

    public Condition getRoomConditions(int id_room) {
        return conditionRepo.findConditionsByRoom(id_room);
    }

    public void setEquipmentValue(int id_equipment, double value) {
        equipmentRepo.setEquipmentValue(id_equipment, value);
    }

    public void setEquipmentAuto(int id_equipment) {
        equipmentRepo.setEquipmentAuto(id_equipment);
    }

    public void setEquipmentManu(int id_equipment) {
        equipmentRepo.setEquipmentManu(id_equipment);
    }

    public void setEquipmentOff(int id_equipment) {
        equipmentRepo.setEquipmentOff(id_equipment);
    }

    public void setEquipmentOn(int id_equipment) {
        equipmentRepo.setEquipmentOn(id_equipment);
    }

    public Condition getLastConditions(int id_room) {
        return conditionRepo.findConditionsByRoom(id_room);
    }

    public void autoAdjustOneEquipment(int id_equipment) {
        Room current_room = roomRepo.findRoomByEquipment(id_equipment);
        Condition current_conditions = conditionRepo.findConditionsByRoom(current_room.getId_room());
        Equipment current_equipment = equipmentRepo.findEquipmentById(id_equipment);
        Equipment_Data current_equipment_data = equipmentRepo.findEquipment_DataById(id_equipment);
        if (current_equipment.getType().equals("radiateur") || current_equipment.getType().equals("fenêtre") || current_equipment.getType().equals("climatisation"))
            this.autoAdjustTemperatureOneEquipment(current_equipment, current_conditions, current_room);

        if (current_equipment.getType().equals("store") || current_equipment.getType().equals("lampe"))
            this.autoAdjustLuminosityOneEquipment(current_equipment, current_conditions, current_room);

    }

    private void autoAdjustLuminosityOneEquipment(Equipment current_equipment, Condition current_conditions, Room current_room) {
        int best_luminosity = 400;
        while (current_conditions.getLuminosity()<= best_luminosity) {
            setEquipmentOneUp(current_equipment.getId_equipment());
            current_conditions = conditionRepo.findConditionsByRoom(current_room.getId_room());
        }
    }

    private void setEquipmentOneUp(int id_equipment) {
        equipmentRepo.setEquipmentOneUp(id_equipment);
    }

    private void autoAdjustTemperatureOneEquipment(Equipment current_equipment, Condition current_conditions, Room current_room) {
        int best_temperature = 21;
        while (current_conditions.getTemperature()<= best_temperature) {
            if (current_equipment.getType().equals("fenêtre"))
                equipmentRepo.setEquipmentOff(current_equipment.getId_equipment());
            else if (current_equipment.getType().equals("climatisation"))
                setEquipmentOneDown(current_equipment.getId_equipment());
            else
                setEquipmentOneUp(current_equipment.getId_equipment());
            current_conditions = conditionRepo.findConditionsByRoom(current_room.getId_room());
        }
    }

    private void setEquipmentOneDown(int id_equipment) {
        equipmentRepo.setEquipmentOneDown(id_equipment);
    }

    public void setBestConditions(int id_room, Condition best_conditions) {

    }
}
