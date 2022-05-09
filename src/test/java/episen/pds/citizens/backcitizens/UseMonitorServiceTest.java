package episen.pds.citizens.backcitizens;

import episen.pds.citizens.backcitizens.model.*;
import episen.pds.citizens.backcitizens.repository.*;
import episen.pds.citizens.backcitizens.service.UseMonitorService;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.LocalTime;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UseMonitorServiceTest extends TestCase {
    @InjectMocks
    UseMonitorService useMonitorService;
    @Mock
    MeasureRepo measureRepo;

    @Mock
    ConditionsRepo conditionsRepo;
    @Mock
    RoomRepo roomRepo;
    @Mock
    EquipmentAndDataRepo equipmentAndDataRepo;

    @Mock
    EquipmentDataRepo equipmentDataRepo;

    @Mock
    EquipmentRepo equipmentRepo;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindEquipmentOrderByRoom() {
        //given
        Iterable<Equipment> equipments = equipmentRepo.findEquipmentOrderByRoom();
        Iterable<Equipment> equipments1 = useMonitorService.findEquipmentOrderByRoom();
        //when
        assertNotNull(equipments); assertNotNull(equipments1);
        //then
        assertEquals(equipments,equipments1);
    }

    @Test
    public void testGetRoomConditions() {
        //given
        Conditions conditions = conditionsRepo.findConditionsByRoom(2);
        Conditions conditions1 = useMonitorService.getLastBestConditions(2);
        //when
        assertNotNull(conditions);assertNotNull(conditions1);
        //then
        assertEquals(conditions, conditions1);
    }

    @Test
    public void testSetEquipmentValue() {
        //when
        equipmentDataRepo.setEquipmentValue(53690,2);
        //then
        assertEquals(equipmentDataRepo.findAllById_equipment_data(53690).getValue(), 2);
    }

    @Test
    public void testSetEquipmentAuto() {
        //when
        equipmentDataRepo.setEquipmentAuto(53690);
        //then
        String statut = equipmentDataRepo.findAllById_equipment_data(53690).getStatut();
        assertEquals(statut, "Automatique");
    }

    @Test
    public void testSetEquipmentManu() {
        //when
        equipmentDataRepo.setEquipmentManu(53690);
        //then
        assertEquals(equipmentDataRepo.findAllById_equipment_data(53690).getType_mode(), "Manuel");
    }

    @Test
    public void testSetEquipmentOff() {
        //when
        equipmentDataRepo.setEquipmentOff(53690);
        //then
        assertEquals(equipmentDataRepo.findAllById_equipment_data(53690).getStatut(), "OFF");
    }

    @Test
    public void testSetEquipmentOn() {
        //when
        equipmentDataRepo.setEquipmentOn(53690);
        //then
        assertEquals(equipmentDataRepo.findAllById_equipment_data(53690).getStatut(), "ON");
    }

    @Test
    public void testGetLastLightMeasure() {
        // given
        Measure measure = useMonitorService.getLastLightMeasure(52740);
        Measure measure1 = measureRepo.getLightStatInRoom(52740);
        // when
        assertNotNull(measure);assertNotNull(measure1);
        // then
        assertEquals(measure,measure1);
    }

    @Test
    public void testGetLastTempMeasure() {
        // given
        Measure measure = useMonitorService.getLastTempMeasure(500);
        Measure measure1 = measureRepo.getTempStatInRoom(500);
        // when
        assertNotNull(measure); assertNotNull(measure1);
        // then
        assertEquals(measure,measure1);
    }

    @Test
    public void testSetEquipmentOneUp() {
        //given
        int cur_value = (int) equipmentDataRepo.findAllById_equipment_data(53690).getValue();
        //when
        equipmentDataRepo.setEquipmentOneUp(53690);
        //then
        int new_value = (int) equipmentDataRepo.findAllById_equipment_data(53690).getValue();
        assertEquals(new_value,cur_value+1);
    }

    @Test
    public  void testSetEquipmentOneDown() {
        //given
        int cur_value = (int) equipmentDataRepo.findAllById_equipment_data(53690).getValue();
        //when
        equipmentDataRepo.setEquipmentOneUp(53690);
        int new_value = (int) equipmentDataRepo.findAllById_equipment_data(53690).getValue();
        //then
        assertEquals(new_value,cur_value-1);
    }

    @Test
    public  void testSetBestConditions() {
        // given
        Conditions conditions = new Conditions();
        conditions.setLuminosity(250); conditions.setBegin_time(LocalDateTime.now());
        conditions.setTemperature(15); conditions.setEnd_time(LocalTime.of(23, 59, 59));
        conditions.setId_room(2);
        // when
        conditionsRepo.save(conditions);
        // then
        assertEquals(useMonitorService.getLastBestConditions(52740).getLuminosity(),250);
        assertEquals(useMonitorService.getLastBestConditions(52740).getTemperature(),15);
    }

    @Test
    public void testGetEquipmentAndDataByRoom() {
        // given
        Iterable<EquipmentAndData> equipmentAndData = equipmentAndDataRepo.getEquipment_DataByIdRoom(52740);
        Iterable<EquipmentAndData> equipmentAndData1 = useMonitorService.getEquipmentAndDataByRoom(52740);
        // when
        assertNotNull(equipmentAndData);assertNotNull(equipmentAndData1);
        // then
        assertEquals(equipmentAndData,equipmentAndData1);
    }

    @Test
    public void testFindAllBusinessRoom() {
        // given
        Iterable<Room> rooms = roomRepo.findAllBusinessRoom(3);
        Iterable<Room> rooms1 = useMonitorService.findAllBusinessRoom(3);
        // when
        assertNotNull(rooms);assertNotNull(rooms1);
        // then
        assertEquals(rooms,rooms1);
    }
}
