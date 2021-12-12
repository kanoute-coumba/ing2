package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.BuildingPatch;
import episen.pds.citizens.backcitizens.repository.BuildingRepoPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingServicePatch {
    @Autowired
    private BuildingRepoPatch buildingRepo;

    public Iterable<BuildingPatch> getBuildings() {
        return buildingRepo.findAll();
    }
}
