package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.BuildingCentral;
import episen.pds.citizens.backcitizens.repository.BuildingCentralRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingCentralService {
    @Autowired
    private BuildingCentralRepo buildingCentralRepo;

    public List<BuildingCentral> readBuildingsTypeCentral() {
        return buildingCentralRepo.readBuildingsTypeCentral();
    }
}
