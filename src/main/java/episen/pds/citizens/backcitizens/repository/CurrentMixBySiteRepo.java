package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.MixEnBySite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CurrentMixBySiteRepo extends CrudRepository<MixEnBySite,Integer> {

    @Query(value = "select mix,t1.address,name_building from " +
            "(select sum(value) as mix, address from production p " +
            "inner join central c on p.id_central=c.id_central " +
            "inner join building b on c.id_building=b.id_building " +
            "where p.id_production in " +
            "(select max from (select max(id_production), id_central from production group by id_central) as c1)" +
            "and name_building in ('solaire','eolienne') " +
            "group by address) as t1 join building b on t1.address=b.address ;", nativeQuery = true)
    public Iterable<MixEnBySite> findEnergyProductionBySite();

}
