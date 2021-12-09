package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Attribution;
import org.springframework.data.jpa.repository.Query;

public interface ConsumptionRepo {
    @Query(value = " select sum(value), id_building from consumption c inner join building b " +
            "where c.id_equipment in (select id_equipment from equipment " +
            "where id_room in (select id_room from room " +
            "where id_floor in (select id_floor from floor))) group by id_building", nativeQuery = true)
    public Iterable<Attribution> findWholeConsumption();
}
