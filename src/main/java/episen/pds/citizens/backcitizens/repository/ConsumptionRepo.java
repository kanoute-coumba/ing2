package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Attribution;
import episen.pds.citizens.backcitizens.model.Consumption;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumptionRepo extends CrudRepository<Consumption, Integer> {
    @Query(value = "select sum(value), id_building from consumption c inner join building b " +
            "where c.id_equipment in (select id_equipment from equipment " +
            "where id_room in (select id_room from room " +
            "where id_floor in (select id_floor from floor))) group by id_building, date_time", nativeQuery = true)
    public Iterable<Consumption> findWholeConsumption();
}
