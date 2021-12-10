package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ConditionRepo extends CrudRepository<Condition, Integer> {

    @Query(nativeQuery = true)
    Iterable<Condition> findConditionsByRoom(int id_room);
}
