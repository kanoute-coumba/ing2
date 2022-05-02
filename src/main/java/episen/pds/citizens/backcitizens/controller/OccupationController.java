package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.BuildingDWP;
import episen.pds.citizens.backcitizens.model.Tenant;
import episen.pds.citizens.backcitizens.model.Workplace;
import episen.pds.citizens.backcitizens.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OccupationController {

    @Autowired
    OccupationService occupationService;
    private static final Logger logger = Logger.getLogger(OccupationController.class.getName());

    @GetMapping("/tenant")
    public Iterable<Tenant> getTenant() {
        logger.config("returning values");
        return occupationService.getTenant();
    }

    @GetMapping("/workplace")
    public Iterable<Workplace> getWorkplace() {
        logger.config("returning values");
        return occupationService.getWorkplace();
    }
    @GetMapping("/buildings")
    public Iterable<BuildingDWP> getDWPbuildings() {
        logger.config("returning values");
        return occupationService.getDWPbuildings();
    }
}
