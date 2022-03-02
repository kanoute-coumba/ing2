package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.MixEnBySite;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CurrentMixBySiteRepo extends CrudRepository<MixEnBySite,Integer> {

    @Query(value = "select mix,t2.address,t2.type_building,active_equip,number_equip from " +
            "(select mix,t1.address,type_building,active_equip from " +
            "(select sum(value) as mix, address, count(c.id_central) as active_equip from production p " +
            "inner join central c on p.id_central=c.id_central inner join building b on c.id_building=b.id_building " +
            "where p.id_production in " +
            "( select p1.id_production from production p1 " +
            "where date_time = (select max(date_time) from production p2 group by p2.id_central having p1.id_central = p2.id_central)) " +
            "and type_building in ('solaire','eolienne','hydraulique') and state = 'actif' " +
            "group by address) as t1 join building b on t1.address=b.address) as t2 join " +
            "(select count(*) as number_equip, address " +
            "from central c inner join building b on c.id_building=b.id_building " +
            "where type_building in ('solaire','eolienne','hydraulique') " +
            "group by address) as t3 on t2.address=t3.address;", nativeQuery = true)
    public Iterable<MixEnBySite> findEnergyProductionBySite();

}
