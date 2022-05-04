package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.*;
import episen.pds.citizens.backcitizens.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return occupationService.getAllTenant();
    }

    @GetMapping("/create_workplace")
    public void createWorkplace() {
        logger.config("returning nothing");
        occupationService.createWorkplace();

    }

    @GetMapping("/create_dwpbybuildings")
    public void createDWPbuildings() {
        logger.config("returning nothing");
        occupationService.createDWPbuildings();
    }

    @GetMapping("/dwp_buildings")
    public Iterable<DWPbyBuilding> getDWPbuildings() {
        logger.config("returning values");
        return occupationService.getDWPbuildings();
    }

    @GetMapping("/create_tenantdetails")
    public void createTenantDetails() {
        logger.config("returning nothing");
        occupationService.createTenantDetails();
        //occupationService.getTenantDetails();
    }

    @GetMapping("/tenantdetails")
    public Iterable<TenantDetails> getTenantDetails() {
        logger.config("returning values");
        return occupationService.getTenantDetails();
    }

    @GetMapping("/create_rentcounterbyyear")
    public void createRentCounterByYear() {
        logger.config("return nothing");
        occupationService.createRentCounterByYear();
    }

    @GetMapping("/rentyearcounter")
    public Iterable<RentCounterByYear> getRentCounterByYear() {
        logger.config("returning values");
        return occupationService.getRentCounterByYear();
    }

    @GetMapping("/create_ratextraction")
    public void createRateXtraction() {
        logger.config("returning nothing");
        occupationService.createRateXtraction();
    }

    @GetMapping("/ratextraction")
    public void getRateXtraction() {
        logger.config("returning nothing");
        occupationService.getRateXtraction();
    }

    @GetMapping("/occupation_rate")
    public Iterable<OccupationRate> getOccupationRate() {
        logger.config("returning values");
        return occupationService.getOccupationRate();
    }

    @GetMapping("/2020rate")
    public Iterable<OccupationRateByBuilding> get2020Rate() {
        logger.config("returning values");
        return occupationService.get2020Rate();
    }

    @GetMapping("/2021rate")
    public Iterable<OccupationRateByBuilding> get2021Rate() {
        logger.config("returning values");
        return occupationService.get2021Rate();
    }

    @GetMapping("/2022rate")
    public Iterable<OccupationRateByBuilding> get2022Rate() {
        logger.config("returning values");
        return occupationService.get2022Rate();
    }
}