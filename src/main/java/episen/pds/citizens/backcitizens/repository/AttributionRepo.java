package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Attribution;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface AttributionRepo extends CrudRepository<Attribution, Integer> {
    @Query (value = " select * from Attribution", nativeQuery = true)
    public Iterable<Attribution> findAttribution();
    }