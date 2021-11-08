package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepo  extends CrudRepository<Configuration, Integer> {}
