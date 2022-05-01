package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Workplace;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkplaceRepo extends CrudRepository<Workplace, Integer> {
    @Query(value = "select space.id_space, space.type_space, space.id_floor, a1.name_floor, a1.id_building, " +
            "a1.name_building from space inner join " +
            "(select floor.id_floor, floor.name_floor, floor.id_building, building.name_building" +
            "from floor inner join building on floor.id_building=building.id_building" +
            "where building.type_building='Entreprise') as a1 " +
            "on space.id_floor=a1.id_floor order by id_space", nativeQuery = true)
    Iterable<Workplace> getWorkplace();
}
