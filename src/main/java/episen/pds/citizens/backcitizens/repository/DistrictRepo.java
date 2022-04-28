package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.District;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepo extends CrudRepository<District, Integer> {
    @Query(value = """
            SELECT di.*, SUM(cs.value) as consumption, SUM(pr.value) as production
            FROM consumption cs, equipment eq, room ro, floor fl, building bu, district di, current_production pr, central ce
            WHERE cs.date_time = (SELECT MAX(date_time)
                              FROM consumption cs1
                              GROUP BY cs1.id_equipment
                              HAVING cs.id_equipment = cs1.id_equipment)
            AND cs.id_equipment = eq.id_equipment
            AND eq.id_room = ro.id_room
            AND ro.id_floor = fl.id_floor
            AND fl.id_building = bu.id_building
            AND pr.id_central = ce.id_central
            AND ce.id_building = bu.id_building
            AND bu.district = di.id_district
            GROUP BY di.id_district
            ORDER BY di.id_district;""",nativeQuery = true)
    List<District> findAll();
}