package episen.pds.citizens.backcitizens.controller;


import episen.pds.citizens.backcitizens.model.architectureModel.Building;
import episen.pds.citizens.backcitizens.model.architectureModel.Floor;
import episen.pds.citizens.backcitizens.model.architectureModel.Space;
import episen.pds.citizens.backcitizens.service.architectureService.BuildingService;
import episen.pds.citizens.backcitizens.service.architectureService.FloorService;
import episen.pds.citizens.backcitizens.service.architectureService.SpaceService;
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
    private final SpaceService spaceService;

    @Autowired
    public ArchitectureController(BuildingService buildingService, FloorService floorService, SpaceService spaceService) {
        this.buildingService = buildingService;
        this.floorService = floorService;
        this.spaceService = spaceService;
    }

    @GetMapping("/buildings")
    public List<Building> getAllBuildings() {
        return buildingService.getAllBuildings();
    }

    @GetMapping(path = "/building/{id_building}")
    public Optional<Building> getBuilding(@PathVariable Integer id_building) {
        return buildingService.getBuilding(id_building);
    }

//    @GetMapping("/floors")
//    public List<Floor> getAllFloors() {
//        return floorService.getAllFloors();
//    }

    @GetMapping("/floors_of/{name_building}")
    public List<Floor> getFloorsOfBuilding(@PathVariable String name_building) {
        return floorService.getFloorsOfBuilding(name_building);
    }

    @GetMapping(path = "/floor/{id_floor}")
    public Optional<Floor> getFloor(@PathVariable Integer id_floor) {
        return floorService.getFloor(id_floor);
    }

//    @GetMapping("/spaces")
//    public List<Space> getAllSpaces() {
//        return SpaceService.getAllSpaces();
//    }

//    @GetMapping("/spaces_of_building/{name_building}")
//    public List<Space> getSpacesOfBuilding(@PathVariable String name_building) {
//        return spaceService.getSpacesOfBuilding(name_building);
//    }

    @GetMapping("/spaces_of_floor/{name_floor}")
    public List<Space> getSpacesOfFloor(@PathVariable String name_floor) {
        return spaceService.getSpacesOfFloor(name_floor);
    }

}

