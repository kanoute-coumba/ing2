package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.Room;
import episen.pds.citizens.backcitizens.model.Tenant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TenantRepo extends CrudRepository<Tenant, Integer> {


    @Query(value = " create table if not exists workplace as (select space.id_space, space.type_space, space.id_floor, a1.id_building from space inner join \n" +
            "(select floor.id_floor, floor.id_building \n" +
            "from floor inner join building on floor.id_building=building.id_building\n" +
            "where building.type_building='Entreprise') as a1 on space.id_floor=a1.id_floor order by id_space) ", nativeQuery = true)

    public Iterable<Tenant> getTenant();

}