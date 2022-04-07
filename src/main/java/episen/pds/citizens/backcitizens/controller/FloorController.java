package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.architectureModel.Floor;
import episen.pds.citizens.backcitizens.service.architectureService.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FloorController {

    @Autowired
    FloorService floorService;

    @GetMapping("/FloorByIdBuilding/{idb}")
    public Iterable<Floor> getFloorByIdBuilding(@PathVariable("idb") int idb){
        return floorService.getFloorByIdBuilding(idb);
    }
}
