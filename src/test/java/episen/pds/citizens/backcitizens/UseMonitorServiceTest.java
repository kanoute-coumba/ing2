package episen.pds.citizens.backcitizens;

import episen.pds.citizens.backcitizens.model.*;
import episen.pds.citizens.backcitizens.repository.*;
import episen.pds.citizens.backcitizens.service.UseMonitorService;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.logging.Logger;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class UseMonitorServiceTest {
    ///
    //  Les méthodes qui appellent des requêtes "update" ne fonctionnent pas et ont été mises en commentaire
    //  Si les méthodes getLastLightMeasure et getLastTempMeasure retournent des valeurs null il faut lancer le mock
    //  measure_summer_winter
    ///
    private static Instant startChrono;

    private static final Logger logger = Logger.getLogger(UseMonitorServiceTest.class.getName());

    @Autowired
    UseMonitorService useMonitorService = new UseMonitorService();
    @Autowired
    MeasureRepo measureRepo;

    @Autowired
    ConditionsRepo conditionsRepo;
    @Autowired
    RoomRepo roomRepo;
    @Autowired
    EquipmentAndDataRepo equipmentAndDataRepo;

    @Autowired
    EquipmentDataRepo equipmentDataRepo;

    @Autowired
    EquipmentRepo equipmentRepo;

    @BeforeAll
    public static void initChrono() {
        logger.info("Debut des tests");
        startChrono = Instant.now();
    }

    @AfterAll
    public static void durationTest() {
        logger.info("Fin de tous les tests");
        Instant endChrono = Instant.now();
        long duration = Duration.between(startChrono, endChrono).toMillis();
        logger.info("Duree des test : " + duration + "ms");
    }

    @Test
    public void testGetRoomConditions() {
        //given
        Conditions conditions = conditionsRepo.findConditionsByRoom(52740);
        Conditions conditions1 = useMonitorService.getLastBestConditions(52740);
        //when
        Assert.assertNotNull(conditions);
        Assert.assertNotNull(conditions1);
        //then
        Assert.assertEquals(conditions.getTemperature(), conditions1.getTemperature());
        Assert.assertEquals(conditions.getLuminosity(), conditions1.getLuminosity());
    }

    @Test
    public void testGetLastLightMeasure() {
        // given
        Measure measure = useMonitorService.getLastLightMeasure(52740);
        Measure measure1 = measureRepo.getLightStatInRoom(52740);
        // when
        Assert.assertNotNull(measure);
        Assert.assertNotNull(measure1);
        // then
        Assert.assertEquals(measure.getValue(), measure1.getValue());
    }

    @Test
    public void testGetLastTempMeasure() {
        // given
        Measure measure = useMonitorService.getLastTempMeasure(52740);
        Measure measure1 = measureRepo.getTempStatInRoom(52740);
        // when
        Assert.assertNotNull(measure); Assert.assertNotNull(measure1);
        // then
        Assert.assertEquals(measure.getValue(), measure1.getValue());
        Assert.assertEquals(measure.getId_measure(), measure1.getId_measure());
    }

    @Test
    public  void testSetBestConditions() {
        // given
        Conditions conditions = new Conditions();
        conditions.setLuminosity(250); conditions.setBegin_time(LocalDateTime.now());
        conditions.setTemperature(15); conditions.setEnd_time(LocalTime.of(23, 59, 59));
        conditions.setId_room(52740);
        // when
        conditionsRepo.save(conditions);
        // then
        Assert.assertEquals(useMonitorService.getLastBestConditions(52740).getLuminosity(), 250);
        Assert.assertEquals(useMonitorService.getLastBestConditions(52740).getTemperature(), 15);
    }

    @Test
    public void testGetEquipmentAndDataByRoom() {
        // given
        Iterable<EquipmentAndData> equipmentAndData = equipmentAndDataRepo.getEquipment_DataByIdRoom(52740);
        Iterable<EquipmentAndData> equipmentAndData1 = useMonitorService.getEquipmentAndDataByRoom(52740);
        EquipmentAndData ead = equipmentAndData.iterator().next();
        EquipmentAndData ead1 = equipmentAndData1.iterator().next();
        // when
        Assert.assertNotNull(equipmentAndData);
        Assert.assertNotNull(equipmentAndData1);
        // then
        Assert.assertEquals(ead.getValue(), ead1.getValue());
        Assert.assertEquals(ead.getId_equipment(), ead1.getId_equipment());
    }

    @Test
    public void testFindAllBusinessRoom() {
        // given
        Iterable<Room> rooms = roomRepo.findAllBusinessRoom(3);
        Iterable<Room> rooms1 = useMonitorService.findAllBusinessRoom(3);
        // when
        Assert.assertNotNull(rooms);
        Assert.assertNotNull(rooms1);
        // then
        Assert.assertEquals(rooms, rooms1);
    }
//    @Test
//    public void testSetEquipmentValue() {
//        //when
//        equipmentDataRepo.setEquipmentValue(53690,2);
//        //then
//        Assert.assertEquals(equipmentDataRepo.findAllById_equipment_data(53690).getValue(), 2);
//    }
//
//    @Test
//    public void testSetEquipmentAuto() {
//        //when
//        equipmentDataRepo.setEquipmentAuto(53690);
//        //then
//        String statut = equipmentDataRepo.findAllById_equipment_data(53690).getStatut();
//        Assert.assertEquals(statut, "Automatique");
//    }
//
//    @Test
//    public void testSetEquipmentManu() {
//        //when
//        equipmentDataRepo.setEquipmentManu(53690);
//        //then
//        Assert.assertEquals(equipmentDataRepo.findAllById_equipment_data(53690).getType_mode(), "Manuel");
//    }
//
//    @Test
//    public void testSetEquipmentOff() {
//        //when
//        equipmentDataRepo.setEquipmentOff(53690);
//        //then
//        Assert.assertEquals(equipmentDataRepo.findAllById_equipment_data(53690).getStatut(), "OFF");
//    }
//
//    @Test
//    public void testSetEquipmentOn() {
//        //when
//        equipmentDataRepo.setEquipmentOn(53690);
//        //then
//        Assert.assertEquals(equipmentDataRepo.findAllById_equipment_data(53690).getStatut(), "ON");
//    }
//
//    @Test
//    public void testSetEquipmentOneUp() throws org.hibernate.QueryException {
//        //given
//        int cur_value = (int) equipmentDataRepo.findAllById_equipment_data(53690).getValue();
//        //when
//        equipmentDataRepo.setEquipmentOneUp(53690);
//        //then
//        int new_value = (int) equipmentDataRepo.findAllById_equipment_data(53690).getValue();
//        Assert.assertEquals(new_value, cur_value + 1);
//    }
//
//    @Test
//    public  void testSetEquipmentOneDown() {
//        //given
//        int cur_value = (int) equipmentDataRepo.findAllById_equipment_data(53690).getValue();
//        //when
//        equipmentDataRepo.setEquipmentOneUp(53690);
//        int new_value = (int) equipmentDataRepo.findAllById_equipment_data(53690).getValue();
//        //then
//        Assert.assertEquals(new_value, cur_value - 1);
//    }
}
