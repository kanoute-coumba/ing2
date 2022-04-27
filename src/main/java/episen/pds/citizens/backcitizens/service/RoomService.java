package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.Room;
import episen.pds.citizens.backcitizens.repository.RoomHouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class RoomService {

    private static final Logger logger = Logger.getLogger(RoomService.class.getName());

    @Autowired
    RoomHouseRepo roomHouseRepo;

    public Iterable<Room> findRoomByIdBuilding(int idb){
        return roomHouseRepo.findRoomByIdBuilding(idb);
    }

}
