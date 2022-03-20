package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.BuildingCentral;
import episen.pds.citizens.backcitizens.model.BuildingHome;
import episen.pds.citizens.backcitizens.service.BuildingCentralService;
import episen.pds.citizens.backcitizens.service.BuildingHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BuildingController {

    @Autowired
    private BuildingHomeService buildingHomeService;

    @Autowired
    private BuildingCentralService buildingCentralService;

    /*@GetMapping("/buildingsPatch")
    public Iterable<BuildingHome> getBuildings() {
        return buildingHomeService.getBuildings();
    }*/

    @GetMapping("/readBuildingsTypeCentral")
    public List<BuildingCentral> readBuildingsTypeCentral() {
        return buildingCentralService.readBuildingsTypeCentral();
    }

    @GetMapping("/readBuildingsByDistrict")
    public List<BuildingHome> readBuildingsByDistrict(@RequestParam int district) {
        return buildingHomeService.readBuildingsByDistrict(district);
    }
}