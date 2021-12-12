package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.CentralWithProduction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CentralWithProductionRepo extends CrudRepository<CentralWithProduction,Integer> {
    @Query(value = "select central.id_central,type,value from central inner join (\n" +
            "select * from production \n" +
            "where id_production in (Select max \n" +
            "from (Select max(id_production),id_central \n" +
            "\tfrom production group by id_central) as c1)) as c2 on \n" +
            "\tc2.id_central=central.id_central\n" +
            "where id_building = :idb order by value",nativeQuery = true)
    public Iterable<CentralWithProduction> getCentralWithProduction(@Param("idb") int id_b);

}
