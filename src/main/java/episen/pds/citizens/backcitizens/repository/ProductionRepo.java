package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Production;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductionRepo extends CrudRepository<Production, Integer> {

    @Query(value = "SELECT * FROM production ORDER BY date_time DESC LIMIT (SELECT count(central.id_central) FROM central);", nativeQuery = true)
    List<Production> findAllLastProduction();

    @Query(value = "Select * from current_production where id_central in " +
            "(Select id_central from central where id_building=:idb)",nativeQuery = true)
    ArrayList<Production> findCurrentProductionByBuilding(@Param("idb") int idb);
}