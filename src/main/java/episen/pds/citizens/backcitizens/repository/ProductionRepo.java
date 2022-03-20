package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Production;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductionRepo extends CrudRepository<Production, Integer> {

    @Query(value = "SELECT * FROM production ORDER BY date_time DESC LIMIT (SELECT count(central.id_central) FROM central);", nativeQuery = true)
    List<Production> findAllLastProduction();
}