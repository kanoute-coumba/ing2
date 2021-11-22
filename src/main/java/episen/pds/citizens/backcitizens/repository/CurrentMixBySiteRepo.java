package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.MixEnBySite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CurrentMixBySiteRepo extends CrudRepository<MixEnBySite,Integer> {
    @Query(value="select sum(value) as mix, address from production p " +
            "inner join central c on p.id_central=c.id_central " +
            "inner join building b on c.id_building=b.id_building " +
            "where p.id_production in (" +
            "select max from (select max(id_production), id_central from production group by id_central) as c1)" +
            " and name_building in ('solaire','eolienne') " +
            "group by address;", nativeQuery = true)
    public Iterable<MixEnBySite> findEnergyProductionBySite();

}
