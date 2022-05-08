package episen.pds.citizens.backcitizens;

import episen.pds.citizens.backcitizens.repository.EquipmentRepo;
import episen.pds.citizens.backcitizens.repository.FloorHouseRepo;
import episen.pds.citizens.backcitizens.repository.HouseRepo;
import episen.pds.citizens.backcitizens.repository.RoomHouseRepo;
import episen.pds.citizens.backcitizens.service.EquipmentService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class EquipmentServiceTest extends TestCase {

    @InjectMocks
    EquipmentService equipmentService = new EquipmentService();

    @Mock
    EquipmentRepo equipmentRepo;

    @Mock
    HouseRepo houseRepo;

    @Mock
    FloorHouseRepo floorRepo;

    @Mock
    RoomHouseRepo roomHouseRepo;

    @Test
    public void testGetEquipmentBYRoom(){
        Integer idr = 1;
        assertEquals(equipmentRepo.findEquipmentByRoom(idr), equipmentService.getEquipmentBYRoom(idr));
    }

    @Test
    public void testGetNameRoomByIdroom(){
        Integer id_room = 60;
        assertEquals(equipmentRepo.findByNameRoom(id_room), equipmentService.getNameRoomByIdroom(id_room));
    }

    @Test
    public void testNameEquipment(){
        Integer id_equipment = 3;
        assertEquals(equipmentRepo.NameEquipment(id_equipment), equipmentService.NameEquipment(id_equipment));
    }

    @Test
    public void testGetIdRoomByEquipment(){
        Integer id_equipment = 10;
        assertEquals(equipmentRepo.findIdRoomByEquipment(id_equipment), equipmentService.getIdRoomByEquipment(id_equipment));
    }

    @Test
    public void testGetHouseByEmail(){
        String email = "Louis Baba";
        assertEquals(houseRepo.findHouseByEmail(email), equipmentService.getHouseByEmail(email));
    }

    @Test
    public void testGetFloors(){
        Integer house =123;
        assertEquals(floorRepo.findFloorByHouse(house), equipmentService.getFloors(house));
    }

    @Test
    public void testGetRoomsByIdFloor(){
        String floor = "1";
        assertEquals(roomHouseRepo.findRoomByFloor(Integer.valueOf(floor)), equipmentService.getRoomsByIdFloor(floor));
    }

    @Test
    public void testGetEquipmentAutomaticPresenceFalse(){
        Integer id_room = 1;
        String nameEquipment = "lampe";
        assertEquals(equipmentRepo.getEquipmentAutomaticFalse(id_room, nameEquipment), equipmentService.getEquipmentAutomaticPresenceFalse(id_room, nameEquipment));
    }

    @Test
    public void testListRoomWithDryerLine(){
        String type_equipment = "sèche-linge";
        String type_mode = "Automatique";
        Integer id_building = 11534;
        assertEquals(equipmentRepo.listRoomWithDryerLine(type_equipment, type_mode, id_building), equipmentService.listRoomWithDryerLine(type_equipment, type_mode, id_building));
    }

    @Test
    public void testGetBeginTime(){
        Integer id_equipment_data = 215728;
        assertEquals(equipmentRepo.getBeginTime(id_equipment_data), equipmentService.getBeginTime(id_equipment_data));
    }

    @Test
    public void testGetEndTime(){
        Integer id_equipment_data = 215728;
        assertEquals(equipmentRepo.getEndTime(id_equipment_data), equipmentService.getEndTime(id_equipment_data));
    }

    @Test
    public void testGetCurrentlyValueSensor(){
        Integer idroom = 91460;
        String currentdate = "2022-01-01 09:00:00.0";
        assertEquals(equipmentRepo.currentlyvalueofsensorPresence(idroom, currentdate), equipmentService.getCurrentlyValueSensor(idroom, currentdate));
    }

    @Test
    public void testPresenceOrNotPresence(){
        Integer idroom = 91460;
        String date = "2022-01-01 09:00:00.0";
        String typesensor = "capteur de présence";
        assertEquals(equipmentRepo.presenOrNotPrsence(idroom, date, typesensor), equipmentService.presenceOrNotPresence(idroom, date, typesensor));
    }

    @Test
    public void testListIdroom(){
        String typesensor = "capteur de présence";
        Integer id_building = 11534;
        assertEquals(equipmentRepo.listIdroom(typesensor, id_building), equipmentService.listIdroom(typesensor, id_building));
    }

    @Test
    public void testVerifyStatutEquipment(){
        Integer id_room = 91460;
        assertEquals(equipmentRepo.getStatutEquipment(id_room), equipmentService.verifyStatutEquipment(id_room));
    }

}
