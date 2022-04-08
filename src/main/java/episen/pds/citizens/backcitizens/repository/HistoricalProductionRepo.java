package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.HistoricalProduction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HistoricalProductionRepo extends CrudRepository<HistoricalProduction,Integer> {
    @Query(value="select b.type_building as energie, t1.mois, t1.jour,sum(moyday) as valeur from \n" +
            "(select ph.id_central, ph.mois, ph.jour, avg(valeur) as moyday from production_historical ph group by (mois,jour,ph.id_central) order by mois,jour) as t1 \n" +
            "inner join central c on t1.id_central=c.id_central \n" +
            "inner join building b on c.id_building=b.id_building \n" +
            "where b.type_building='solaire' and t1.jour=1 \n" +
            "group by b.type_building, t1.mois, t1.jour \n" +
            "order by case mois when 'janvier' then 1 when 'fevrier' then 2 when 'mars' then 3 when 'avril' then 4 when 'mai' then 5 when 'juin' then 6 when 'juillet' then 7 when 'aout' then 8 when 'septembre' then 9 when 'octobre' then 10 when 'novembre' then 11 when 'decembre' then 12 end asc , jour"
            , nativeQuery = true)
    public Iterable<HistoricalProduction> findHistoricalProductionForSolar();

    @Query(value="select b.type_building as energie, t1.mois, t1.jour,sum(moyday) as valeur from\n" +
            "(select ph.id_central, ph.mois, ph.jour, avg(valeur) as moyday from production_historical ph group by (mois,jour,ph.id_central) order by mois,jour) as t1\n" +
            "inner join central c on t1.id_central=c.id_central \n" +
            "inner join building b on c.id_building=b.id_building\n" +
            "where b.type_building='eolienne' and t1.jour=1\n" +
            "group by b.type_building, t1.mois, t1.jour \n" +
            "order by case mois when 'janvier' then 1 when 'fevrier' then 2 when 'mars' then 3 when 'avril' then 4 when 'mai' then 5 when 'juin' then 6 when 'juillet' then 7 when 'aout' then 8 when 'septembre' then 9 when 'octobre' then 10 when 'novembre' then 11 when 'decembre' then 12 end asc , jour\n"
            , nativeQuery = true)
    public Iterable<HistoricalProduction> findHistoricalProductionForWind();

    @Query(value="select b.type_building as energie, t1.mois, t1.jour,sum(moyday) as valeur from \n" +
            "(select ph.id_central, ph.mois, ph.jour, avg(valeur) as moyday from production_historical ph group by (mois,jour,ph.id_central) order by mois,jour) as t1 \n" +
            "inner join central c on t1.id_central=c.id_central \n" +
            "inner join building b on c.id_building=b.id_building \n" +
            "where b.type_building='hydraulique' and t1.jour=1 \n" +
            "group by b.type_building, t1.mois, t1.jour \n" +
            "order by case mois when 'janvier' then 1 when 'fevrier' then 2 when 'mars' then 3 when 'avril' then 4 when 'mai' then 5 when 'juin' then 6 when 'juillet' then 7 when 'aout' then 8 when 'septembre' then 9 when 'octobre' then 10 when 'novembre' then 11 when 'decembre' then 12 end asc , jour"
            , nativeQuery = true)
    public Iterable<HistoricalProduction> findHistoricalProductionForHydraulic();

}
