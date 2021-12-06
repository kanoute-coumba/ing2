package episen.pds.citizens.backcitizens.service.architectureService;

import episen.pds.citizens.backcitizens.model.architectureModel.Building;
import episen.pds.citizens.backcitizens.repository.architectureRepository.BuildingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class BuildingService {
    private final BuildingRepo buildingRepo;

    @Autowired
    public BuildingService(BuildingRepo buildingRepo) {
        this.buildingRepo = buildingRepo;
    }

    public List<Building> getAllBuildings() {
        return buildingRepo.getAllBuildings();
    }

    public Optional<Building> getBuilding(Integer id_building) {
        return buildingRepo.findById(id_building);
    }
}

