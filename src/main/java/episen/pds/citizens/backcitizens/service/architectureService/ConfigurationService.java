package episen.pds.citizens.backcitizens.service.architectureService;

import episen.pds.citizens.backcitizens.model.architectureModel.Configuration;
import episen.pds.citizens.backcitizens.repository.architectureRepository.ConfigurationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ConfigurationService {
    private final ConfigurationRepo configurationRepo;

    @Autowired
    public ConfigurationService(ConfigurationRepo configurationRepo) {
        this.configurationRepo = configurationRepo;
    }

    public List<Configuration> getAllConfigurations() {
        return configurationRepo.getAllConfigurations();
    }

    public Optional<Configuration> getConfiguration(Integer id_configuration) {
        return configurationRepo.findById(id_configuration);
    }

}

