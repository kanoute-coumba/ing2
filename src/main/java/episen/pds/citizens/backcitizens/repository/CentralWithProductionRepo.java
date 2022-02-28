package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.CentralWithProduction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CentralWithProductionRepo extends CrudRepository<CentralWithProduction,Integer> {
    @Query(value = """
            select central.id_central,type,value from central inner join (
            SELECT cs.id_central, cs.value FROM production cs
            WHERE date_time = (SELECT MAX(date_time)
            FROM production cs1 GROUP BY cs1.id_central
            HAVING cs.id_central = cs1.id_central)) as c2 on
            c2.id_central=central.id_central
            where id_building =:idb order by value""",nativeQuery = true)
    Iterable<CentralWithProduction> getCentralWithProduction(@Param("idb") int id_b);

}
