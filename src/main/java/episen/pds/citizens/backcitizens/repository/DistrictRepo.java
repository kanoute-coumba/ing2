package episen.pds.citizens.backcitizens.repository;

import episen.pds.citizens.backcitizens.model.District;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepo extends CrudRepository<District, Integer> {
    List<District> findAll();
}