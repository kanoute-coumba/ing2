package episen.pds.citizens.backcitizens;

import episen.pds.citizens.backcitizens.model.*;
import episen.pds.citizens.backcitizens.repository.*;
import episen.pds.citizens.backcitizens.service.UseMonitorService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.LocalTime;

@RunWith(MockitoJUnitRunner.class)
public class UseMonitorServiceTest  {
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
    SensorRepo sensorRepo;

    @Mock
    EquipmentRepo equipmentRepo;

    @Test
    public void testFindEquipmentOrderByRoom() {
        Assert.assertEquals(equipmentRepo.findEquipmentOrderByRoom(), useMonitorService.findEquipmentOrderByRoom());
    }

    @Test
    public void testGetRoomConditions() {
        Assert.assertEquals(conditionsRepo.findConditionsByRoom(2), useMonitorService.getRoomConditions(2));
    }

    @Test
    public synchronized void testSetEquipmentValue() {
        equipmentDataRepo.setEquipmentValue(53690,2);
        Assert.assertEquals(equipmentDataRepo.findEquipment_DataById(53690).getValue(), 2);
    }

    @Test
    public synchronized void testSetEquipmentAuto() {
        equipmentDataRepo.setEquipmentAuto(53690);
        String statut = equipmentDataRepo.findEquipment_DataById(53690).getStatut();
        Assert.assertEquals(statut, "Automatique");
    }

    @Test
    public synchronized void testSetEquipmentManu() {
        equipmentDataRepo.setEquipmentManu(2);
        Assert.assertEquals(equipmentDataRepo.findEquipment_DataById(53690).getType_mode(), "Manuel");
    }

    @Test
    public synchronized void testSetEquipmentOff() {
        equipmentDataRepo.setEquipmentOff(2);
        Assert.assertEquals(equipmentDataRepo.findEquipment_DataById(53690).getStatut(), "OFF");
    }

    @Test
    public synchronized void testSetEquipmentOn() {
        equipmentDataRepo.setEquipmentOn(2);
        Assert.assertEquals(equipmentDataRepo.findEquipment_DataById(53690).getStatut(), "ON");
    }

    @Test
    public void testGetLastBestConditions() {
        Assert.assertEquals(useMonitorService.getLastBestConditions(5149),conditionsRepo.findConditionsByRoom(5149));
    }

    @Test
    public void testGetLastLightMeasure() {
        Assert.assertEquals(useMonitorService.getLastLightMeasure(2),measureRepo.getLightStatInRoom(2));
    }

    @Test
    public void testGetLastTempMeasure() {
        Assert.assertEquals(useMonitorService.getLastTempMeasure(500),measureRepo.getTempStatInRoom(500));
    }

    @Test
    public synchronized void testSetEquipmentOneUp() {
        int cur_value = (int) equipmentDataRepo.findEquipment_DataById(53690).getValue();
        equipmentDataRepo.setEquipmentOneUp(2);
        int new_value = (int) equipmentDataRepo.findEquipment_DataById(53690).getValue();
        Assert.assertEquals(new_value,cur_value+1);
    }

    @Test
    public synchronized void testSetEquipmentOneDown() {
        int cur_value = (int) equipmentDataRepo.findEquipment_DataById(53690).getValue();
        equipmentDataRepo.setEquipmentOneUp(2);
        int new_value = (int) equipmentDataRepo.findEquipment_DataById(53690).getValue();
        Assert.assertEquals(new_value,cur_value-1);
    }

    @Test
    public synchronized void testSetBestConditions() {
        Conditions conditions = new Conditions();
        conditions.setLuminosity(250); conditions.setBegin_time(LocalDateTime.now());
        conditions.setTemperature(15); conditions.setEnd_time(LocalTime.of(23, 59, 59));
        conditions.setId_room(2);
        conditionsRepo.save(conditions);
        Assert.assertEquals(useMonitorService.getLastBestConditions(2).getLuminosity(),250);
        Assert.assertEquals(useMonitorService.getLastBestConditions(2).getTemperature(),15);
    }

    @Test
    public void testGetEquipmentAndDataByRoom() {
        Assert.assertEquals(equipmentAndDataRepo.getEquipment_DataByIdRoom(52740),useMonitorService.getEquipmentAndDataByRoom(52740));
    }

    @Test
    public void testFindAllBusinessRoom() {
        Assert.assertEquals(roomRepo.findAllBusinessRoom(3),useMonitorService.findAllBusinessRoom(3));
    }
}
