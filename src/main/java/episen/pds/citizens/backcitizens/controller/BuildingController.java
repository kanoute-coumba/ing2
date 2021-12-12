package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.BuildingPatch;
import episen.pds.citizens.backcitizens.service.BuildingServicePatch;
import episen.pds.citizens.backcitizens.service.architectureService.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BuildingController {
    @Autowired
    private BuildingServicePatch buildingServicePatch;

    @GetMapping("/buildingsPatch")
    public Iterable<BuildingPatch> getBuildings() {
        return buildingServicePatch.getBuildings();
    }
}