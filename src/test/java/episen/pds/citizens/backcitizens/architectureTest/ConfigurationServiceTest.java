package episen.pds.citizens.backcitizens.architectureTest;

import episen.pds.citizens.backcitizens.exception.BadRequestException;
import episen.pds.citizens.backcitizens.exception.ConfigurationNotFoundException;
import episen.pds.citizens.backcitizens.model.architectureModel.Configuration;
import episen.pds.citizens.backcitizens.repository.architectureRepository.ConfigurationRepo;
import episen.pds.citizens.backcitizens.service.architectureService.ConfigurationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class ConfigurationServiceTest {

    @Mock private ConfigurationRepo configurationRepo;
    private ConfigurationService underTest;

    @BeforeEach
    void setUp() {
        underTest = new ConfigurationService(configurationRepo);
    }

    @Test
    void canGetAllConfigurations() {
        underTest.getAllConfigurations();
        verify(configurationRepo).findAll();
    }

    @Test
    void canAddConfiguration() {
        Configuration configuration = new Configuration(5,null,13,3,10,5,10,10);
        underTest.addConfiguration(configuration);
        ArgumentCaptor<Configuration> ConfigurationArgumentCaptor = ArgumentCaptor.forClass(Configuration.class);
        verify(configurationRepo).save(ConfigurationArgumentCaptor.capture());
        Configuration capturedConfiguration = ConfigurationArgumentCaptor.getValue();
        assertThat(capturedConfiguration).isEqualTo(configuration);
    }

    @Test
    void willThrowWhenEmailIsTaken() {
        Configuration configuration = new Configuration(5,null,13,3,10,5,10,10);
        given(configurationRepo.selectExistsConfiguration(anyInt())).willReturn(true);
        assertThatThrownBy(() -> underTest.addConfiguration(configuration))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("La configuration ayant l'Id " + configuration.getId_configuration() + " existe déjà");
        verify(configurationRepo, never()).save(any());
    }

    @Test
    void canDeleteConfiguration() {
        Integer id = 10;
        given(configurationRepo.existsById(id)).willReturn(true);
        underTest.deleteConfiguration(id);
        verify(configurationRepo).deleteById(id);
    }

    @Test
    void willThrowWhenDeleteConfigurationNotFound() {
        Integer id = 10;
        given(configurationRepo.existsById(id)).willReturn(false);
        assertThatThrownBy(() -> underTest.deleteConfiguration(id))
                .isInstanceOf(ConfigurationNotFoundException.class)
                .hasMessageContaining("La configuration ayant l'Id " + id + " n'existe pas");
        verify(configurationRepo, never()).deleteById(any());
    }
}