package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Workplace;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface WorkplaceRepo extends CrudRepository<Workplace, Integer> {

    @Transactional
    @Modifying
    @Query(value = "create table if not exists workplace as (select space.id_space, space.type_space, space.id_floor, " +
            "a1.id_building from space inner join (select floor.id_floor, floor.id_building " +
            "from floor inner join building on floor.id_building=building.id_building " +
            "where building.type_building='Entreprise') as a1 " +
            "on space.id_floor=a1.id_floor order by id_space)", nativeQuery = true)
    public void createWorkplace();

}
