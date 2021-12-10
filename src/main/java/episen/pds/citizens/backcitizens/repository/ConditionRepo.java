package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Condition;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:sql_queries.properties")
public interface ConditionRepo extends CrudRepository<Condition, Integer> {

    @Query(value = "select * from conditions where id_room=?1",nativeQuery = true)
    Iterable<Condition> findConditionsByRoom(int id_room);
}
