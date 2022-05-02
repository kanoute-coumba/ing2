package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.BuildingHome;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingHomeRepo extends CrudRepository<BuildingHome, Integer> {
    @Query(value = """
            SELECT bu.*, SUM(cs.value) as consumption, SUM(pr.value) as production
            FROM consumption cs, equipment eq, room ro, floor fl, building bu, current_production pr, central ce
            WHERE bu.district =:district
            AND cs.date_time = (SELECT MAX(date_time)
                              FROM consumption cs1
                              GROUP BY cs1.id_equipment
                              HAVING cs.id_equipment = cs1.id_equipment)
            AND cs.id_equipment = eq.id_equipment
            AND eq.id_room = ro.id_room
            AND ro.id_floor = fl.id_floor
            AND fl.id_building = bu.id_building
            AND pr.id_central = ce.id_central
            AND ce.id_building = bu.id_building
            GROUP BY bu.id_building;""", nativeQuery = true)
    List<BuildingHome> readBuildingsByDistrict(@Param("district") int district);
}