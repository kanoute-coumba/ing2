package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Building;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepo extends CrudRepository<Building, Integer> {}
