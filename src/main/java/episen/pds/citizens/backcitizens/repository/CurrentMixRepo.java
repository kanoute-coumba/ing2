package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.MixEn;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CurrentMixRepo extends CrudRepository<MixEn,Integer> {
    @Query(value="select sum(value) as mix, type_building from current_production p " +
            "inner join central c on p.id_central=c.id_central " +
            "inner join building b on c.id_building=b.id_building " +
            "where p.id_production in (" +
            "select p.id_production from current_production p " +
            "where date_time = (select max(date_time) from current_production p2 group by p2.id_central having p.id_central = p2.id_central))" +
            " and type_building in ('solaire','eolienne','hydraulique') and state = 'actif' " +
            "group by type_building;", nativeQuery = true)
    public Iterable<MixEn> findEnergyProduction();

    @Query(value="select avg(capacity) as mix, type_building from current_production p " +
            "inner join central c on p.id_central = c.id_central " +
            "inner join building b on c.id_building = b.id_building " +
            "where type_building in ('solaire','eolienne','hydraulique') " +
            "group by type_building " +
            "order by type_building", nativeQuery = true)
    public List<MixEn> getCapacityByEn();

    @Query(value="select count(*) as mix, type as type_building from central " +
            "where id_building in (select id_building from building where type_building in ('solaire','eolienne','hydraulique')) " +
            "group by type " +
            "order by type_building", nativeQuery = true)
    public List<MixEn> getNbCentralByEn();

}
