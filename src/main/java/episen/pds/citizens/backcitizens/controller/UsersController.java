package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.Users;
import episen.pds.citizens.backcitizens.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsersController {


    @Autowired
    private UsersService usersService;
    private static final Logger logger = Logger.getLogger(UsersController.class.getName());

 /*   @PostMapping("/users")
    public void saveMenu(@RequestBody Users users) {
        logger.config("receiving values menu_reservation");
        logger.config(users.toString());
        UsersService.saveMenuReservation(menu_reservation);
    }

  */
 /*   @GetMapping("/cafeteria_reservation")
    public Optional<Menu_reservation> getMenuReservation(@PathVariable int id) {
        logger.config("returning menu values");
        return menuService.getMenuReservation(id);
    } */

    @GetMapping("/users")
    public Iterable<Users> getUsers() {
        logger.config("returning values");
        return usersService.getUser();
    }

    @GetMapping("/users/{id}")
    public Optional<Users> getUserById(@PathVariable int id) {
        logger.config("returning menu values");
        //logger.config(Users.toString());
        return usersService.getUserById(id);
    }
    @GetMapping("/usersName={uName}")
    public Iterable<Users> getUsersByUserName(@PathVariable("uName") String uName) {
        logger.config("returning uName");
        return usersService.getUserByUserName(uName);
    }
}
