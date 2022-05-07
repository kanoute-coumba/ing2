package episen.pds.citizens.backcitizens.repository.architectureRepository;

import episen.pds.citizens.backcitizens.model.architectureModel.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface ConfigurationRepo extends JpaRepository<Configuration, Integer> {
    @Query(value = "select * from configuration ORDER BY id_configuration", nativeQuery = true)
    List<Configuration> getAllConfigurations();

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN TRUE ELSE FALSE END FROM Configuration c WHERE c.id_configuration = ?1")
    Boolean selectExistsConfiguration(Integer id_configuration);
}


