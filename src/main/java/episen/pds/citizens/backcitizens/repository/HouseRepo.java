package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.architectureModel.Building;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface HouseRepo extends JpaRepository<Building, Integer> {
    @Query(value = "select b.id_building, address, name_building, type_building, district from building b inner join userbuilding u\n" +
            "    on b.id_building = u.id_building inner join users us\n" +
            "        on u.id_user = us.user_id where username=?1", nativeQuery = true)
    List<Building> findHouseByEmail(String email);





}
