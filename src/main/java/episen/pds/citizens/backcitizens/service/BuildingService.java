package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.Building;
import episen.pds.citizens.backcitizens.repository.BuildingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {
    @Autowired
    private BuildingRepo buildingRepo;

    public Iterable<Building> getBuildings() {
        return buildingRepo.findAll();
    }
}
