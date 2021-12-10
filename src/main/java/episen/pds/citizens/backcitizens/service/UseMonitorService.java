package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.*;
import episen.pds.citizens.backcitizens.repository.*;
import episen.pds.citizens.frontend.model.ConsumptionByBuilding;
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

    public Iterable<Condition> getRoomConditions(int id_room) {
        return conditionRepo.findConditionsByRoom(id_room);
    }
}
