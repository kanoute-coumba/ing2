package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Production;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductionRepo extends CrudRepository<Production, Integer> {
    @Query(value = "Select * from current_production where id_central in " +
            "(Select id_central from central where id_building=:idb)",nativeQuery = true)
    ArrayList<Production> findCurrentProductionByBuilding(@Param("idb") int idb);

    @Query(value = """
        SELECT pr.*    
        FROM building bu, central ce, current_production pr
        WHERE bu.type_building =:type
        AND pr.id_central = ce.id_central
        AND ce.id_building = bu.id_building;""", nativeQuery = true)
    List<Production> findAllProductionByCentralType(String type);
}