package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.Configuration;
import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.model.Equipment;
import episen.pds.citizens.backcitizens.model.Room;
import episen.pds.citizens.backcitizens.repository.ConfigurationRepo;
import episen.pds.citizens.backcitizens.repository.ConsumptionRepo;
import episen.pds.citizens.backcitizens.repository.EquipmentRepo;
import episen.pds.citizens.backcitizens.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UseMonitorService {
    @Autowired
    private ConfigurationRepo configurationRepo;
    private EquipmentRepo equipmentRepo;
    private ConsumptionRepo consumptionRepo;
    private RoomRepo roomRepo;

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

    // CONFIGURATIONS

    public Optional<Configuration> getConfigurationById(int id_configuration) {
        return configurationRepo.findById(id_configuration);
    }
    public Iterable<Configuration> getAllConfigurations() {
        return configurationRepo.findAll();
    }

    // EQUIPMENT

    public Optional<Equipment> getEquipmentById(int id_equipment) {
        return equipmentRepo.findById(id_equipment);
    }
    public Iterable<Equipment> getAllEquipment() {
        return equipmentRepo.findAll();
    }
    public void saveEquipment(Equipment equipment) {
        equipmentRepo.save(equipment);
    }
    // CONSUMPTION

    public Optional<Consumption> getConsumptionByDate(String date) {
        return consumptionRepo.findConsumptionByDate(date);
    }
    public Iterable<Consumption> getAllConsumption() {
        return consumptionRepo.findAll();
    }
}
