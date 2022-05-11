package episen.pds.citizens.backcitizens;

import episen.pds.citizens.backcitizens.controller.MenuController;
import episen.pds.citizens.backcitizens.model.RSpace;
import episen.pds.citizens.backcitizens.model.Reservation;
import episen.pds.citizens.backcitizens.repository.ReservationRepo;
import episen.pds.citizens.backcitizens.repository.SpacesRepo;
import episen.pds.citizens.backcitizens.service.ReservationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationServiceTest {

    @Autowired
    private ReservationRepo reservationRepo;

    @Autowired
    private SpacesRepo spacesRepo;

    @Autowired
    private ReservationService reservationService;


    private static final Logger logger = Logger.getLogger(ReservationServiceTest.class.getName());

    @Test
    public void getReservationByIdTest() {
        // given
        Reservation spacesService = reservationService.getReservationById(1065);
        Reservation spaceRepo = reservationRepo.findById(1065).get();
        // when
        Assert.assertNotNull(spacesService);
        Assert.assertNotNull(spaceRepo);
        // then
        Assert.assertEquals(spacesService.getId_space(), spaceRepo.getId_space());
        Assert.assertEquals(spacesService.getUser_id(), spaceRepo.getUser_id());
    }


//    @Test
//    public void getReservedSpaceTest() {
//        // given
//        Iterable<RSpace> spacesService = reservationService.getReservedSpace();
//        Iterable<RSpace> spaceRepo = spacesRepo.findReservedSpaces();
//        // when
//        Assert.assertNotNull(spacesService);
//        Assert.assertNotNull(spaceRepo);
//        // then
//        Assert.assertEquals(spacesService.iterator().next().getId_floor(), spaceRepo.iterator().next().getId_floor());
//        Assert.assertEquals(spacesService.iterator().next().getName_space(), spaceRepo.iterator().next().getName_space());
//    }

    @Test
    public void getDispoSpaceTest() {
        // given
        Iterable<RSpace> spacesService = reservationService.getDispoSpace(1652097600, 1652097600, "Bureau", 1);
        Iterable<RSpace> spaceRepo = spacesRepo.findDispoSpaces(1652097600, 1652097600, "Bureau", 1);
        // when
        Assert.assertNotNull(spacesService);
        Assert.assertNotNull(spaceRepo);
        // then
        Assert.assertEquals(spacesService.iterator().next().getUser_id(), spaceRepo.iterator().next().getUser_id());
    }
    @Test
    public void saveMenuReservationTest() {
        Reservation resa = new Reservation();
        resa.setReservation_id(9000);
        resa.setEnd_time(1652109600);
        resa.setStart_time(1652099600);
        resa.setUser_id(5);
        resa.setId_space(72);

        reservationRepo.save(resa);

        Reservation reservation = reservationService.getReservationById(5);

        Assert.assertEquals(reservation.getUser_id(), resa.getUser_id());

        reservationRepo.delete(resa);

    }




}

