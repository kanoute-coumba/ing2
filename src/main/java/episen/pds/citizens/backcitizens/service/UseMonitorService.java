package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.Room;
import episen.pds.citizens.backcitizens.repository.ConfigurationRepo;
import episen.pds.citizens.backcitizens.repository.ConsumptionRepo;
import episen.pds.citizens.backcitizens.repository.EquipmentRepo;
import episen.pds.citizens.backcitizens.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseMonitorService {
    @Autowired
    private ConfigurationRepo configurationRepo;
    private EquipmentRepo equipmentRepo;
    private ConsumptionRepo consumptionRepo;
    private RoomRepo roomRepo;

    public Iterable<Room> getRoom(int id_room) {
        roomRepo.getRoom(id_room);
    }
}
