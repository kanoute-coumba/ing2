package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.Menu;
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


    @GetMapping("/cafeteria/{id}")
    public Optional<Menu> getMenuById(@PathVariable int id) {
        logger.config("returning menu values");
        return menuService.getMenuById(id);
    }

}
