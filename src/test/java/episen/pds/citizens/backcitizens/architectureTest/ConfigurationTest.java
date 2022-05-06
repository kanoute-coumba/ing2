package episen.pds.citizens.backcitizens.architectureTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import episen.pds.citizens.backcitizens.model.architectureModel.Configuration;
import episen.pds.citizens.backcitizens.repository.architectureRepository.ConfigurationRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-it.properties"
)
@AutoConfigureMockMvc
public class ConfigurationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ConfigurationRepo configurationRepo;

    @Test
    void canRegisterNewConfiguration() throws Exception {
        Configuration configuration = new Configuration((int)Math.random(),null,(int)Math.random(), (int)Math.random(), (int)Math.random(), (int)Math.random(), (int)Math.random(), (int)Math.random());
        ResultActions resultActions = mockMvc
                .perform(post("/api/v1/configurations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(configuration)));
        resultActions.andExpect(status().isOk());
        List<Configuration> configurations = configurationRepo.findAll();
        assertThat(configurations).usingElementComparatorIgnoringFields("id").contains(configuration);
    }

    @Test
    void canDeleteConfiguration() throws Exception {
        Configuration configuration = new Configuration((int)Math.random(),null,(int)Math.random(), (int)Math.random(), (int)Math.random(), (int)Math.random(), (int)Math.random(), (int)Math.random());
        mockMvc.perform(post("/api/v1/configurations")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(configuration)))
                .andExpect(status().isOk());
        MvcResult getConfigurationsResult = mockMvc.perform(get("/api/v1/configurations")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String contentAsString = getConfigurationsResult.getResponse().getContentAsString();
        List<Configuration> configurations = objectMapper.readValue(contentAsString, new TypeReference<>() {});

        Integer id = configurations.stream()
                .filter(s -> s.getId_configuration().equals(configuration.getId_configuration()))
                .map(Configuration::getId_configuration)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("La configuration ayant l'Id " + configuration.getId_configuration() + " n'a pas été retrouvé"));

        ResultActions resultActions = mockMvc.perform(delete("/api/v1/configurations/" + id));
        resultActions.andExpect(status().isOk());
        boolean exists = configurationRepo.existsById(id);
        assertThat(exists).isFalse();
    }
}
