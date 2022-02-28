package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.BuildingPatch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepoPatch extends CrudRepository<BuildingPatch, Integer> {
    @Query(value = "SELECT bu.*, SUM(cs.value) as consumption, SUM(pr.value) as production\n" +
            "FROM consumption cs, equipment eq, room ro, floor fl, building bu, production pr, central ce\n" +
            "WHERE cs.date_time = (SELECT MAX(date_time)\n" +
            "                   FROM consumption cs1\n" +
            "                   GROUP BY cs1.id_equipment\n" +
            "                   HAVING cs.id_equipment = cs1.id_equipment)\n" +
            "AND pr.date_time = (SELECT MAX(date_time)\n" +
            "               FROM production pr1\n" +
            "               GROUP BY pr1.id_central\n" +
            "               HAVING pr.id_central = pr1.id_central)\n" +
            "AND cs.id_equipment = eq.id_equipment\n" +
            "AND eq.id_room = ro.id_room\n" +
            "AND ro.id_floor = fl.id_floor\n" +
            "AND fl.id_building = bu.id_building\n" +
            "AND pr.id_central = ce.id_central\n" +
            "AND ce.id_building = bu.id_building\n" +
            "GROUP BY bu.id_building;", nativeQuery = true)
    public Iterable<BuildingPatch> findAll();
}