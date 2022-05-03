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
    //@Autowired
    //private DWPbyBuildingContainsRepo dwpByBuildingContainsRepo;
    @Autowired
    private RentCounterByYearRepo rentCounterByYearRepo;
    @Autowired
    private TenantDetailsRepo tenantDetailsRepo;

    public Iterable<Tenant> getAllTenant() {
        return tenantRepo.getAllTenant();
    }
    public void createTenantDetails() {
        tenantDetailsRepo.createTenantDetails();
    }
    public void createDWPbuildings() {
        buildingDWPRepo.createDWPbuildings();
    }
    public Iterable<RentCounterByYear> getCounterByYear() {
        return rentCounterByYearRepo.getCounterByYear();
    }
    public void createWorkplace() {
        workplaceRepo.createWorkplace();
    }
    public Iterable<DWPbyBuilding> getDWPbuildings() {
        return buildingDWPRepo.getDWPbuildings();
    }

}
