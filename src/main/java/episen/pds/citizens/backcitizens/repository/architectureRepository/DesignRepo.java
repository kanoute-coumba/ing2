package episen.pds.citizens.backcitizens.repository.architectureRepository;

import episen.pds.citizens.backcitizens.model.architectureModel.Design;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;


public interface DesignRepo extends JpaRepository<Design, Integer> {
    @Query(value = "select * from design WHERE name_design = ?1", nativeQuery = true)
    Optional<Design> getDesignByName(String name_design);

}

