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
}



