package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.*;
import episen.pds.citizens.backcitizens.repository.*;
import episen.pds.citizens.backcitizens.repository.DWPbyBuildingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OccupationService {
    @Autowired
    private TenantRepo tenantRepo;
    @Autowired
    private WorkplaceRepo workplaceRepo;
    @Autowired
    private DWPbyBuildingRepo buildingDWPRepo;
    @Autowired
    private RentCounterByYearRepo rentCounterByYearRepo;
    @Autowired
    private TenantDetailsRepo tenantDetailsRepo;
    @Autowired
    private RateXtractionRepo rateXtractionRepo;
    @Autowired
    private OccupationRateRepo occupationRateRepo;

    public Iterable<Tenant> getAllTenant() {
        return tenantRepo.getAllTenant();
    }
    public void createWorkplace() {
        workplaceRepo.createWorkplace();
    }
    public void createTenantDetails() {
        tenantDetailsRepo.createTenantDetails();
    }
    public void createDWPbuildings() {
        buildingDWPRepo.createDWPbuildings();
    }
    public void createRentCounterByYear() {
        rentCounterByYearRepo.createRentCounterByYear();}

    public Iterable<RentCounterByYear> getCounterByYear() {
        return rentCounterByYearRepo.getCounterByYear();
    }

    public Iterable<DWPbyBuilding> getDWPbuildings() {
        return buildingDWPRepo.getDWPbuildings();
    }

    public void createRateXtraction() {
        rateXtractionRepo.createRateXtraction();
    }

    public void getRateXtraction() {
        rateXtractionRepo.getRateXtraction();
    }

    public Iterable<OccupationRate> getOccupationRate() {
        return occupationRateRepo.getOccupationRate();
    }

}
