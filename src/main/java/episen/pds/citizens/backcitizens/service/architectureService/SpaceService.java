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

    public Optional<Space> getSpaceByName(String name_space) {
        return spaceRepo.getSpaceByName(name_space);
    }

    public List<Space> getSpacesOfFloor(String name_floor) {
        return spaceRepo.getSpacesOfFloor(name_floor);
    }

    public List<Space> getSpacesOfFloorByType(String name_floor, String type_space) {
        return spaceRepo.getSpacesOfFloorByType(name_floor,type_space);
    }

}

