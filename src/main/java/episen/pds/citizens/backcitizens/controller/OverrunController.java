package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.Attribution;
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
    public Iterable<Attribution> getOverrun() {
        logger.config("returning values");
        return overrunService.getOverrun();
    }

    @GetMapping("/whole")
    public Iterable<Attribution> getConsumption() {
        logger.config("returning values");
        return overrunService.getConsumption();
    }

}
