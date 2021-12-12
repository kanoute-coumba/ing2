package episen.pds.citizens.backcitizens.service.architectureService;

import episen.pds.citizens.backcitizens.model.architectureModel.Space;
import episen.pds.citizens.backcitizens.repository.architectureRepository.SpaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SpaceService {

    private final SpaceRepo spaceRepo;

    @Autowired
    public SpaceService(SpaceRepo spaceRepo) {
        this.spaceRepo = spaceRepo;
    }

//    public List<Space> getAllSpaces() {
//        return spaceRepo.findAll();
//    }

//    public List<Space> getSpacesOfBuilding(String name_building) {
//        return spaceRepo.getSpacesOfBuilding(name_building);
//    }

    public List<Space> getSpacesOfFloor(String name_floor) {
        return spaceRepo.getSpacesOfFloor(name_floor);
    }

    public Optional<Space> getSpace(Integer id_space) {
        return spaceRepo.findById(id_space);
    }

}

