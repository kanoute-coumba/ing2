package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Conditions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ConditionsRepo extends CrudRepository<Conditions, Integer> {

    @Query( value = "Update conditions set temperature =:valueTemperature WHERE id_room =:id_room AND id_floor =:id_floor", nativeQuery = true )
    void findByValueChambre(@Param("valueTemperature") Integer valueTemperature, @Param("id_room") Integer id_room, @Param("id_floor") Integer id_floor );

    @Query(value = "select * from conditions where id_room=?1",nativeQuery = true)
    Iterable<Conditions> findConditionsByRoom(int id_room);

    @Query(value = "select * from conditions where id_room=?1  " +
            "and current_time between begin_time and end_time;",nativeQuery = true)
    Conditions findLastConditionsByRoom(int id_room);

}



