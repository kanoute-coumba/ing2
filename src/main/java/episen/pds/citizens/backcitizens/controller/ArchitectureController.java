package episen.pds.citizens.backcitizens.controller;


import episen.pds.citizens.backcitizens.model.architectureModel.Building;
import episen.pds.citizens.backcitizens.model.architectureModel.Design;
import episen.pds.citizens.backcitizens.model.architectureModel.Floor;
import episen.pds.citizens.backcitizens.model.architectureModel.Space;
import episen.pds.citizens.backcitizens.service.architectureService.BuildingService;
import episen.pds.citizens.backcitizens.service.architectureService.DesignService;
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
    private final DesignService designService;

    @Autowired
    public ArchitectureController(BuildingService buildingService, FloorService floorService, SpaceService spaceService, DesignService designService) {
        this.buildingService = buildingService;
        this.floorService = floorService;
        this.spaceService = spaceService;
        this.designService = designService;
    }

    // ********************************************* Building Controller ********************************************* //

    @GetMapping("/buildings")
    public List<Building> getAllBuildings() {
        return buildingService.getAllBuildings();
    }

    // Not yet
    @GetMapping(path = "/building/{id_building}")
    public Optional<Building> getBuilding(@PathVariable Integer id_building) {
        return buildingService.getBuilding(id_building);
    }

    // ********************************************* Floor Controller ********************************************* //

    @GetMapping("/floors_of/{name_building}")
    public List<Floor> getFloorsOfBuilding(@PathVariable String name_building) {
        return floorService.getFloorsOfBuilding(name_building);
    }

    // Not yet
    @GetMapping(path = "/floor/{id_floor}")
    public Optional<Floor> getFloor(@PathVariable Integer id_floor) {
        return floorService.getFloor(id_floor);
    }

    @GetMapping(path = "/design_of/{name_floor}")
    public String getDesignOfFloor(@PathVariable String name_floor) {
        return floorService.getDesignOfFloor(name_floor);
    }

    // ********************************************* Space Controller ********************************************* //

    // Not yet
    @GetMapping("/spaces_of_building/{name_building}")
    public List<Space> getSpacesOfBuilding(@PathVariable String name_building) {
        return spaceService.getSpacesOfBuilding(name_building);
    }

    @GetMapping("/spaces_of_floor/{name_floor}")
    public List<Space> getSpacesOfFloor(@PathVariable String name_floor) {
        return spaceService.getSpacesOfFloor(name_floor);
    }

    @GetMapping("/spaces_of_floor_by_type/{name_floor}/{type_space}")
    public List<Space> getSpacesOfFloorByType(@PathVariable String name_floor,@PathVariable String type_space) {
        return spaceService.getSpacesOfFloorByType(name_floor,type_space);
    }

    // Not yet
    @GetMapping(path = "/space/{id_space}")
    public Optional<Space> getSpace(@PathVariable Integer id_space) {
        return spaceService.getSpace(id_space);
    }

    // ********************************************* Design Controller ********************************************* //

    // Not yet
    @GetMapping("/designs")
    public List<Design> getAllDesigns() {
        return designService.getAllDesigns();
    }

    // Not yet
    @GetMapping("/design/{id_design}")
    public Optional<Design> getDesign(@PathVariable Integer id_design) {
        return designService.getDesign(id_design);
    }

    // Not yet
    @GetMapping("/design_by_name/{name_design}")
    public Optional<Design> getDesignByName(@PathVariable String name_design) {
        return designService.getDesignByName(name_design);
    }

}

