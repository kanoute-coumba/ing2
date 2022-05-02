package episen.pds.citizens.backcitizens.repository;


import episen.pds.citizens.backcitizens.model.Messages;
import episen.pds.citizens.backcitizens.model.RSpace;
import episen.pds.citizens.backcitizens.model.architectureModel.Space;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
    public interface SpacesRepo extends CrudRepository<Space, Integer> {

    @Query(value="select * from space inner join reservation on space.id_space=reservation.id_space inner join users on users.user_id=reservation.user_id;", nativeQuery = true)
    Iterable<Space> findReservedSpaces();
}