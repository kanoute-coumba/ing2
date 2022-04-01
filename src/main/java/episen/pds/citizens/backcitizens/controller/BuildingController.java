package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.BuildingCentral;
import episen.pds.citizens.backcitizens.model.BuildingHome;
import episen.pds.citizens.backcitizens.model.architectureModel.Building;
import episen.pds.citizens.backcitizens.service.BuildingCentralService;
import episen.pds.citizens.backcitizens.service.BuildingHomeService;
import episen.pds.citizens.backcitizens.service.architectureService.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BuildingController {

    @Autowired
    private BuildingHomeService buildingHomeService;
    @Autowired
    private BuildingService buildingService;
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
    @GetMapping("/BuildingByUser/{idu}")
    public Iterable<Building> getBuildingByUser(@PathVariable("idu") int idu){
        return buildingService.getBuildingByIdUser(idu);
    }
}