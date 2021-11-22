package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Consumption;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ConsumptionRepo extends CrudRepository<Consumption, Integer> {
    @Query(value = "SELECT * FROM consumption ORDER BY value ", nativeQuery = true)
            //" SELECT SUM(value) as conso2020 FROM consumption WHERE date_time < '2020-12-31'", nativeQuery = true)
    public Iterable<Consumption> findConsoValue();
}
