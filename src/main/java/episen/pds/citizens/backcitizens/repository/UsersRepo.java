package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface UsersRepo extends CrudRepository<Users, Integer> {
}