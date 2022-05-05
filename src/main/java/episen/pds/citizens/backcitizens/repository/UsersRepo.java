package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
    public interface UsersRepo extends CrudRepository<Users, Integer> {

    @Query(value = "select * from users where username=:uName",nativeQuery = true)
    Iterable<Users> findUsersByUsername(@Param("uName") String uName);

    @Query(value = "select * from users where user_id=:id",nativeQuery = true)
    Users findUsersByUserId(@Param("id") int id);
}