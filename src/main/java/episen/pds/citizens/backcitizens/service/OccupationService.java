package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.ConsumptionDay;
import episen.pds.citizens.backcitizens.model.Tenant;
import episen.pds.citizens.backcitizens.repository.ConsumptionDayRepo;
import episen.pds.citizens.backcitizens.repository.TenantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OccupationService {
    @Autowired
    private TenantRepo tenantRepo;

    public Iterable<Tenant> getTenant() {
        return tenantRepo.getTenant();
    }
}
