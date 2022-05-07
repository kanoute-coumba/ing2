//package episen.pds.citizens.backcitizens.architectureTest;
//
//import episen.pds.citizens.backcitizens.model.architectureModel.Configuration;
//import episen.pds.citizens.backcitizens.repository.architectureRepository.ConfigurationRepo;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//@DataJpaTest
//class ConfigurationRepoTest {
//
//    @Autowired
//    private ConfigurationRepo underTest;
//
//    @AfterEach
//    void tearDown() {
//        underTest.deleteAll();
//    }
//
//    @Test
//    void itShouldCheckWhenConfigurationIdExists() {
//        Configuration configuration = new Configuration(5,null,13,3,10,5,10,10);
//        underTest.save(configuration);
//        boolean expected = underTest.selectExistsConfiguration(5);
//        assertThat(expected).isTrue();
//    }
//
//    @Test
//    void itShouldCheckWhenConfigurationIdDoesNotExists() {
//        boolean expected = underTest.selectExistsConfiguration(5);
//        assertThat(expected).isFalse();
//    }
//}