package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.controller.MenuController;
import episen.pds.citizens.backcitizens.model.Menu;
import episen.pds.citizens.backcitizens.model.Menu_reservation;
import episen.pds.citizens.backcitizens.model.Test;
import episen.pds.citizens.backcitizens.repository.MenuRepo;
import episen.pds.citizens.backcitizens.repository.MenuReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class MenuService {

    @Autowired
    private MenuRepo menuRepo;


    @Autowired
    private MenuReservationRepo menuReservationRepo;

    private static final Logger logger = Logger.getLogger(MenuController.class.getName());

    public Optional<Menu> getMenuById(final int id) {
        return menuRepo.findById(id);
    }
    public Optional<Menu_reservation> getMenuReservation(final int id) {
        return menuReservationRepo.findById(id);
    }

    public Iterable<Menu> getMenu() {
        return menuRepo.findAll();
    }

    public Menu_reservation saveMenuReservation(Menu_reservation menu_reservation) {
        logger.config(menu_reservation.toString());
        return menuReservationRepo.save(menu_reservation);
    }


}

