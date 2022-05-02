package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.Tenant;
import episen.pds.citizens.backcitizens.model.Workplace;
import episen.pds.citizens.backcitizens.repository.TenantRepo;
import episen.pds.citizens.backcitizens.repository.WorkplaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OccupationService {
    @Autowired
    private TenantRepo tenantRepo;
    @Autowired
    private WorkplaceRepo workplaceRepo;

    public Iterable<Tenant> getTenant() {
        return tenantRepo.getTenant();
    }

    public Iterable<Workplace> getWorkplace() {
        return workplaceRepo.getWorkplace();
    }
}
