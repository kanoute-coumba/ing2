package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Attribution;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface AttributionRepo extends CrudRepository<Attribution, Integer> {
    @Query(value = " SELECT t2.date, t1.consoday, t2.value " +
            " FROM consobyday t1 INNER JOIN attribution t2 " +
            " ON t1.date = t2.date where t1.consoday > t2.value " +
            "group by(t2.date,t1.consoday, t2.value) order by (date)", nativeQuery=true)
    public Iterable<Attribution> getAttribution();
    }
