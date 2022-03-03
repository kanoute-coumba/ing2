package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.architectureModel.Building;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface HouseRepo extends JpaRepository<Building, Integer> {
    @Query(value = "select id_building,address, name_building, type_building, id_owner, district from building inner join \"users\" u on building.id_owner = u.user_id where username=?1", nativeQuery = true)
    List<Building> findHouseByEmail(String email);





}
