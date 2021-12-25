package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.equipments.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HouseRepo extends JpaRepository<House, Integer> {
    @Query(value = "select id_house,address,id_owner from house inner join \"user\" u on house.id_owner = u.id_citizen where email=?1", nativeQuery = true)
    List<House> findHouseByEmail(String email);




}
