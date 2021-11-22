package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.model.Test;
import episen.pds.citizens.backcitizens.service.ConsumptionService;
import episen.pds.citizens.backcitizens.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ConsumptionController {

    @Autowired
    private ConsumptionService consumptionService;
    private static final Logger logger = Logger.getLogger(ConsumptionController.class.getName());

    @GetMapping("/consumption")
    public Iterable<Consumption> getConsumption() {
        logger.config("returning values");
        return consumptionService.getConsumption();
    }

}
