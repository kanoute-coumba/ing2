package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.Attribution;
import episen.pds.citizens.backcitizens.model.ConsumptionDay;
import episen.pds.citizens.backcitizens.model.PeakDay;
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

    @GetMapping("/attribmock")
    public Iterable<Attribution> getAllAttribAfterMock() {
        logger.config("returning values");
        return overrunService.getAllAttribAfterMock();
    }
    @GetMapping("/consomock")
    public Iterable<ConsumptionDay> getAllConsoAfterMock() {
        logger.config("returning values");
        return overrunService.getAllConsoAfterMock();
    }

    @GetMapping("/attribution")
    public Iterable<Attribution> getAttribution() {
        logger.config("Building energy attributed");
        return overrunService.getAttribution();
    }

    @GetMapping("/conso")
    public Iterable<ConsumptionDay> getConsumption() {
        logger.config("Consumption per day in the SmartCity");
        return overrunService.getConsumption();
    }

    @GetMapping("/peak")
    public Iterable<PeakDay> getPeakDay() {
        logger.config("Find all peak days in the SmartCity");
        return overrunService.getPeakDay();
    }

    /*@RequestMapping("/peak")

    public PeakDay getPeakDay(@RequestBody (required = false)) {
        logger.config("receiving values");
        return overrunService.getPeakDay();
    }

     */

    @GetMapping("/statistiques")
    public Iterable<PeakDay> getPeak() {
        logger.config("Count all peak days in the SmartCity");
        return overrunService.getPeak();
    }

}
