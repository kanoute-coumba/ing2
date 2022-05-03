package episen.pds.citizens.backcitizens;

import episen.pds.citizens.backcitizens.model.Room;
import episen.pds.citizens.backcitizens.model.architectureModel.Building;
import episen.pds.citizens.backcitizens.model.architectureModel.Floor;
import episen.pds.citizens.backcitizens.repository.*;
import episen.pds.citizens.backcitizens.repository.architectureRepository.FloorRepo;
import episen.pds.citizens.backcitizens.service.EquipmentService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;



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
        String house = "2 rue du palais, Paris";
        assertEquals(floorRepo.findFloorByHouse(house), equipmentService.getFloors(house));
    }

    @Test
    public void testGetRoomsByIdFloor(){
        String floor = "1";
        assertEquals(roomHouseRepo.findRoomByFloor(Integer.valueOf(floor)), equipmentService.getRoomsByIdFloor(floor));
    }


}
