package episen.pds.citizens.backcitizens.repository;


import episen.pds.citizens.backcitizens.model.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestRepo extends CrudRepository<Test, Integer> {}