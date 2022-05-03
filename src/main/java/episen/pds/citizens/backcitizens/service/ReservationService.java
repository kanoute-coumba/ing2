package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.controller.MenuController;
import episen.pds.citizens.backcitizens.model.RSpace;
import episen.pds.citizens.backcitizens.model.Reservation;
import episen.pds.citizens.backcitizens.model.Menu_reservation;
import episen.pds.citizens.backcitizens.repository.MenuReservationRepo;
import episen.pds.citizens.backcitizens.repository.ReservationRepo;
import episen.pds.citizens.backcitizens.repository.SpacesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import episen.pds.citizens.backcitizens.model.architectureModel.Space;


import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepo reservationRepo;

    @Autowired
    private SpacesRepo spacesRepo;

    private static final Logger logger = Logger.getLogger(MenuController.class.getName());

    public Optional<Reservation> getReservationById(final int id) {
        return reservationRepo.findById(id);
    }

    public Iterable<Reservation> getReservation() {
        return reservationRepo.findAll();
    }
    //public Iterable<Space> getSpace() {
     //   return spacesRepo.findAll();
   // }

    public Iterable<RSpace> getReservedSpace() {
        return spacesRepo.findReservedSpaces();
    }


    public Reservation saveMenuReservation(Reservation reservation) {
        logger.config(reservation.toString());
        return reservationRepo.save(reservation);
    }


}

