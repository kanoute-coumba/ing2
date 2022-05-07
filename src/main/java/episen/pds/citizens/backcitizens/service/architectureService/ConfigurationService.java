package episen.pds.citizens.backcitizens.service.architectureService;

import episen.pds.citizens.backcitizens.exception.BadRequestException;
import episen.pds.citizens.backcitizens.exception.ConfigurationNotFoundException;
import episen.pds.citizens.backcitizens.model.architectureModel.Configuration;
import episen.pds.citizens.backcitizens.repository.architectureRepository.ConfigurationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
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

    public void addConfiguration(Configuration configuration) {
        Boolean existsConfiguration = configurationRepo.selectExistsConfiguration(configuration.getId_configuration());
        if (existsConfiguration) {
            throw new BadRequestException("La configuration ayant l'Id " + configuration.getId_configuration() + " existe déjà.");
        }
        configurationRepo.save(configuration);
    }

    public void deleteConfiguration(Integer id_configuration) {
        if(!configurationRepo.existsById(id_configuration)) {
            throw new ConfigurationNotFoundException("La configuration ayant l'Id " + id_configuration + " n'existe pas");
        }
        configurationRepo.deleteById(id_configuration);
    }

}

