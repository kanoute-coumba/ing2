package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.RSpace;
import episen.pds.citizens.backcitizens.model.Reservation;
import episen.pds.citizens.backcitizens.model.Users;
import episen.pds.citizens.backcitizens.model.architectureModel.Space;
import episen.pds.citizens.backcitizens.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    private static final Logger logger = Logger.getLogger(ReservationController.class.getName());

    @PostMapping("/reservations")
    public void saveReservation(@RequestBody Reservation reservation) {
        logger.config("receiving values reservation");
        logger.config(reservation.toString());
        reservationService.saveMenuReservation(reservation);
    }

    @GetMapping("/spaces")
    public Iterable<RSpace> getSpace() {
        logger.config("returning values REEEEEEESAAAAAAAAAAAAA");
        return reservationService.getReservedSpace();
    }

    @GetMapping("/reservations")
    public Iterable<Reservation> getReservation() {
        logger.config("returning values REEEEEEESAAAAAAAAAAAAA");
        return reservationService.getReservation();
    }

 /*   @GetMapping("/cafeteria_reservation")
    public Optional<Menu_reservation> getMenuReservation(@PathVariable int id) {
        logger.config("returning menu values");
        return menuService.getMenuReservation(id);
    } */

    @GetMapping("/reservations/{id}")
    public Optional<Reservation> getReservationById(@PathVariable int id) {
        logger.config("returning menu values");
        return reservationService.getReservationById(id);
    }

}
