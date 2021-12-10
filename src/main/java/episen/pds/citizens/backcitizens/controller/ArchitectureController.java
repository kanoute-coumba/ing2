package episen.pds.citizens.backcitizens.controller;


import episen.pds.citizens.backcitizens.model.architectureModel.Building;
import episen.pds.citizens.backcitizens.model.architectureModel.Floor;
import episen.pds.citizens.backcitizens.service.architectureService.BuildingService;
import episen.pds.citizens.backcitizens.service.architectureService.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "architecture")
@RestController
public class ArchitectureController {
    private final BuildingService buildingService;
    private final FloorService floorService;

    @Autowired
    public ArchitectureController(BuildingService buildingService, FloorService floorService) {
        this.buildingService = buildingService;
        this.floorService = floorService;
    }

    @GetMapping("/buildings")
    public List<Building> getAllBuildings() {
        return buildingService.getAllBuildings();
    }

    @GetMapping(path = "/building/{id_building}")
    public Optional<Building> getBuilding(@PathVariable Integer id_building) {
        return buildingService.getBuilding(id_building);
    }

    @GetMapping("/floors")
    public List<Floor> getAllFloors() {
        return floorService.getAllFloors();
    }

    @GetMapping("/floors_of/{name_building}")
    public List<Floor> getFloorsOfBuilding(@PathVariable String name_building) {
        return floorService.getFloorsOfBuilding(name_building);
    }

    @GetMapping(path = "/floor/{id_floor}")
    public Optional<Floor> getFloor(@PathVariable Integer id_floor) {
        return floorService.getFloor(id_floor);
    }

}

