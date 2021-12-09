package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Attribution;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface OverrunRepo extends CrudRepository<Attribution, Integer> {


    }