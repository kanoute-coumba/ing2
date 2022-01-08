package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.Menu;
import episen.pds.citizens.backcitizens.model.Menu_reservation;
import episen.pds.citizens.backcitizens.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MenuController {

    @Autowired
    private MenuService menuService;
    private static final Logger logger = Logger.getLogger(MenuController.class.getName());

    @PostMapping("/cafeteria_reservation")
    public void saveMenu(@RequestBody Menu_reservation menu_reservation) {
        logger.config("receiving values menu_reservation");
        logger.config(menu_reservation.toString());
        menuService.saveMenuReservation(menu_reservation);
    }
 /*   @GetMapping("/cafeteria_reservation")
    public Optional<Menu_reservation> getMenuReservation(@PathVariable int id) {
        logger.config("returning menu values");
        return menuService.getMenuReservation(id);
    } */

    @GetMapping("/cafeteria/{id}")
    public Optional<Menu> getMenuById(@PathVariable int id) {
        logger.config("returning menu values");
        return menuService.getMenuById(id);
    }

}
