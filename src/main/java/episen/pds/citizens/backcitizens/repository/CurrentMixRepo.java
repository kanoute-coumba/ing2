package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.MixEn;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CurrentMixRepo extends CrudRepository<MixEn,Integer> {
    @Query(value="select sum(value) as mix, name_building from production p " +
            "inner join central c on p.id_central=c.id_central " +
            "inner join building b on c.id_building=b.id_building " +
            "where p.id_production in (" +
            "select max from (select max(id_production), id_central from production group by id_central) as c1)" +
            " and name_building in ('solaire','eolienne','hydraulique') and state = 'actif' " +
            "group by name_building;", nativeQuery = true)
    public Iterable<MixEn> findEnergyProduction();

}
