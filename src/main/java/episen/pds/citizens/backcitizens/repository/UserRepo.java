package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {}
