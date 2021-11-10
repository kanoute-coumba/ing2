package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Equipment;
import episen.pds.citizens.backcitizens.model.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepo extends CrudRepository<Room, Integer>  {
}
