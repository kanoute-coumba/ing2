package episen.pds.citizens.backcitizens.service.architectureService;

import episen.pds.citizens.backcitizens.model.architectureModel.Design;
import episen.pds.citizens.backcitizens.repository.architectureRepository.DesignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class DesignService {
    private final DesignRepo designRepo;

    @Autowired
    public DesignService(DesignRepo designRepo) {
        this.designRepo = designRepo;
    }

    public List<Design> getAllDesigns() {
        return designRepo.findAll();
    }

    public Optional<Design> getDesign(Integer id_design) {
        return designRepo.findById(id_design);
    }

    public Optional<Design> getDesignByName(String name_design) {
        return designRepo.getDesignByName(name_design);
    }

}

