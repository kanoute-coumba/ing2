package episen.pds.citizens.backcitizens.service.architectureService;

import episen.pds.citizens.backcitizens.model.architectureModel.Floor;
import episen.pds.citizens.backcitizens.repository.architectureRepository.FloorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FloorService {

    private final FloorRepo floorRepo;

    @Autowired
    public FloorService(FloorRepo floorRepo) {
        this.floorRepo = floorRepo;
    }

    public List<Floor> getFloorsOfBuilding(String name_building) {
        return floorRepo.getFloorsOfBuilding(name_building);
    }

    // Not yet
    public Optional<Floor> getFloor(Integer id_floor) {
        return floorRepo.findById(id_floor);
    }

    public String getDesignOfFloor(String name_floor) {
        return floorRepo.getDesignOfFloor(name_floor);
    }

    public Iterable<Floor> getFloorByIdBuilding(int idb){
        return floorRepo.getFloorById_building(idb);
    }

}

