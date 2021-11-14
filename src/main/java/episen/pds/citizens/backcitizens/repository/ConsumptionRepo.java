package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Consumption;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ConsumptionRepo extends CrudRepository<Consumption, Integer> {
    public Optional<Consumption> findConsumptionByDate(String date);
}
