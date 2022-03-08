package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.Attribution;
import episen.pds.citizens.backcitizens.model.ConsumptionDay;
import episen.pds.citizens.backcitizens.model.PeakDay;
import episen.pds.citizens.backcitizens.model.PeakYear;
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

    @GetMapping("/statistiques")
    public Iterable<PeakYear> getPeak() {
        logger.config("Count all peak days in the SmartCity");
        return overrunService.getPeak();
    }

    @GetMapping("/2020")
    public Iterable<PeakYear> getPeak20() {
        logger.config("Count peaks by months in 2020");
        return overrunService.getPeak20();
    }

    @GetMapping("/2021")
    public Iterable<PeakYear> getPeak21() {
        logger.config("Count peaks by months in 2021");
        return overrunService.getPeak21();
    }

    @GetMapping("/2022")
    public Iterable<PeakYear> getPeak22() {
        logger.config("Count peaks by months in 2022");
        return overrunService.getPeak22();
    }

}
