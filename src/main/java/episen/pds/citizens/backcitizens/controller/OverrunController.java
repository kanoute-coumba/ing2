package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.Attribution;
import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.service.OverrunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class OverrunController {

    @Autowired
    OverrunService overrunService;
    private static final Logger logger = Logger.getLogger(OverrunController.class.getName());

    @GetMapping("/overrun")
    public Iterable<Attribution> getAttribution() {
        logger.config("Building energy attributed");
        return overrunService.getAttribution();
    }

    @GetMapping("/conso")
    public Iterable<Consumption> getConsumption() {
        logger.config("Consumption per equipment per day");
        return overrunService.getConsumption();
    }

}
