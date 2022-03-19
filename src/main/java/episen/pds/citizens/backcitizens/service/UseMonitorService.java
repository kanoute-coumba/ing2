package episen.pds.citizens.backcitizens.service;


import episen.pds.citizens.backcitizens.model.*;
import episen.pds.citizens.backcitizens.model.equipments.Equipment;
import episen.pds.citizens.backcitizens.model.Room;
import episen.pds.citizens.backcitizens.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UseMonitorService {

    @Autowired
    private EquipmentRepo equipmentRepo;

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

    public Conditions getRoomConditions(int id_room) {
        return conditionRepo.findConditionsByRoom(id_room);
    }

    public synchronized void setEquipmentValue(int id_equipment, double value) {
        equipmentDataRepo.setEquipmentValue(id_equipment, value);
    }

    public synchronized void setEquipmentAuto(int id_equipment) {
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
        return conditionRepo.findConditionsByRoom(id_room);
    }

    public Measure getLastLightMeasure(int id_room) {
        return measureRepo.getLightStatInRoom(id_room);
    }

    public Measure getLastTempMeasure(int id_room) {
        return measureRepo.getTempStatInRoom(id_room);
    }


    public synchronized void setEquipmentOneUp(int id_equipment) {
        equipmentDataRepo.setEquipmentOneUp(id_equipment);
    }

    public synchronized void setEquipmentOneDown(int id_equipment) {
        equipmentDataRepo.setEquipmentOneDown(id_equipment);
    }

    public synchronized void setBestConditions(Conditions best_conditions) {
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
