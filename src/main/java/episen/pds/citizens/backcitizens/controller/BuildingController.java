package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.Building;
import episen.pds.citizens.backcitizens.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @GetMapping("/buildings")
    public Iterable<Building> getBuildings() {
        return buildingService.getBuildings();
    }
}