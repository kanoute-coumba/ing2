package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Consumption;
import org.springframework.data.repository.CrudRepository;

public interface ConsumptionRepo extends CrudRepository<Consumption, Integer> {
}
