package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.Menu_reservation;
import episen.pds.citizens.backcitizens.model.RSpace;
import episen.pds.citizens.backcitizens.model.Reservation;
import episen.pds.citizens.backcitizens.model.Users;
import episen.pds.citizens.backcitizens.model.architectureModel.Space;
import episen.pds.citizens.backcitizens.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;

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

//    @GetMapping("/spaces")
//    public Iterable<RSpace> getSpace() {
//        logger.config("returning values REEEEEEESAAAAAAAAAAAAA");
//        return reservationService.getReservedSpace();
//    }

//    @GetMapping("/reservations")
//    public Iterable<Reservation> getReservation() {
//        logger.config("returning values REEEEEEESAAAAAAAAAAAAA");
//        return reservationService.getReservation();
//    }

    @GetMapping("/reservations/{idu}/{heureDebut}/{heureFin}/{typeEspace}")
    public Iterable<RSpace> getDispoReservation(@PathVariable("idu") int idu, @PathVariable("heureDebut") long heureDebut, @PathVariable("heureFin") long heureFin, @PathVariable("typeEspace") String typeEspace) {
        logger.config("returning values REEEEEEESAAAAAAAAAAAAA");
        return reservationService.getDispoSpace(heureDebut, heureFin, typeEspace, idu);
    }

 /*   @GetMapping("/cafeteria_reservation")
    public Optional<Menu_reservation> getMenuReservation(@PathVariable int id) {
        logger.config("returning menu values");
        return menuService.getMenuReservation(id);
    } */

    @GetMapping("/reservations/{id}")
    public Reservation getReservationById(@PathVariable int id) {
        logger.config("returning menu values");
        return reservationService.getReservationById(id);
    }

    @PostMapping("/reservations/saved/{idu}/{heureDebut}/{heureFin}/{id_space}")
    public void saveResa(@PathVariable("idu") String idu,  @PathVariable("heureDebut") String heureDebut,  @PathVariable("heureFin") String heureFin,  @PathVariable("id_space") String id_space) {
        Reservation reservation2 = new Reservation();
        reservation2.setUser_id(parseInt(idu));
        reservation2.setStart_time(Long.parseLong(heureDebut));
        reservation2.setEnd_time(Long.parseLong(heureFin));
        reservation2.setId_space(parseInt(id_space));
        reservation2.setReservation_id(6000);
        System.out.println("LOOOOOOOOOOOOOOOOOOL");
        logger.config("receiving values menu_reservation");
        logger.config(reservation2.toString());
        reservationService.saveMenuReservation(reservation2);
    }


}
