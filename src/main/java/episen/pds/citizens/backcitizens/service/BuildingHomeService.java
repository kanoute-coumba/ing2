package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.BuildingHome;
import episen.pds.citizens.backcitizens.repository.BuildingHomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingHomeService {
    @Autowired
    private BuildingHomeRepo buildingHomeRepo;

    public List<BuildingHome> readBuildingsByDistrict(int district) {
        return buildingHomeRepo.readBuildingsByDistrict(district);
    }
}