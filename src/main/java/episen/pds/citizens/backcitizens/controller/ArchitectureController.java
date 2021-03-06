package episen.pds.citizens.backcitizens.controller;


import episen.pds.citizens.backcitizens.model.architectureModel.*;
import episen.pds.citizens.backcitizens.service.architectureService.*;
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
    private final ConfigurationService configurationService;

    @Autowired
    public ArchitectureController(BuildingService buildingService, FloorService floorService, SpaceService spaceService, DesignService designService, ConfigurationService configurationService) {
        this.buildingService = buildingService;
        this.floorService = floorService;
        this.spaceService = spaceService;
        this.designService = designService;
        this.configurationService = configurationService;
    }

    // ********************************************* Building Controller ********************************************* //

    @GetMapping("/buildings")
    public List<Building> getAllBuildings() {
        return buildingService.getAllBuildings();
    }

    @GetMapping(path = "/building/{id_building}")
    public Optional<Building> getBuilding(@PathVariable Integer id_building) {
        return buildingService.getBuilding(id_building);
    }

    // ********************************************* Floor Controller ********************************************* //

    @GetMapping("/floors_of/{name_building}")
    public List<Floor> getFloorsOfBuilding(@PathVariable String name_building) {
        return floorService.getFloorsOfBuilding(name_building);
    }

    @GetMapping(path = "/floor/{id_floor}")
    public Optional<Floor> getFloor(@PathVariable Integer id_floor) {
        return floorService.getFloor(id_floor);
    }

    @GetMapping(path = "/design_of/{name_floor}")
    public String getDesignOfFloor(@PathVariable String name_floor) {
        return floorService.getDesignOfFloor(name_floor);
    }

    // ********************************************* Space Controller ********************************************* //

    @GetMapping("/spaces/{name_space}")
    public Optional<Space> getSpaceByName(@PathVariable String name_space) {
        return spaceService.getSpaceByName(name_space);
    }

    @GetMapping("/spaces_of_floor/{name_floor}")
    public List<Space> getSpacesOfFloor(@PathVariable String name_floor) {
        return spaceService.getSpacesOfFloor(name_floor);
    }

    @GetMapping("/spaces_of_floor_by_type/{name_floor}/{type_space}")
    public List<Space> getSpacesOfFloorByType(@PathVariable String name_floor,@PathVariable String type_space) {
        return spaceService.getSpacesOfFloorByType(name_floor,type_space);
    }

    // ********************************************* Design Controller ********************************************* //

    @GetMapping("/designs")
    public List<Design> getAllDesigns() {
        return designService.getAllDesigns();
    }

    @GetMapping("/design/{id_design}")
    public Optional<Design> getDesign(@PathVariable Integer id_design) {
        return designService.getDesign(id_design);
    }

    @GetMapping("/design_by_name/{name_design}")
    public Optional<Design> getDesignByName(@PathVariable String name_design) {
        return designService.getDesignByName(name_design);
    }

    // ********************************************* Configuration Controller ********************************************* //

    @GetMapping("/configurations")
    public List<Configuration> getAllConfigurations() {
        return configurationService.getAllConfigurations();
    }

    @PostMapping
    public void addConfiguration(@RequestBody Configuration configuration) {
        configurationService.addConfiguration(configuration);
    }

    @DeleteMapping(path = "{configurationId}")
    public void deleteConfiguration(@PathVariable("configurationId") Integer id_configuration) {
        configurationService.deleteConfiguration(id_configuration);
    }

}

