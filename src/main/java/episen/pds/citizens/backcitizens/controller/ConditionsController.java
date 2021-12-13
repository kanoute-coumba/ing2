package episen.pds.citizens.backcitizens.controller;


import episen.pds.citizens.backcitizens.service.ConditionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ConditionsController {

    @Autowired
    private ConditionsService conditionsService;
    private static final Logger logger = Logger.getLogger(ConditionsController.class.getName());


    @PostMapping("/ValueChambre")
    public void ValueRoomTemperature(@RequestParam("valueTemperature") Integer valueTemperature, @RequestParam("id_room") Integer id_room, @RequestParam("id_floor") Integer id_floor ) {
        logger.config("returning values");
        conditionsService.getValueTemperature(valueTemperature, id_room, id_floor);
    }
}
