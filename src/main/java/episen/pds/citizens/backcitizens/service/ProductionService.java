package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.Production;
import episen.pds.citizens.backcitizens.repository.ProductionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionService {
    @Autowired
    private ProductionRepo productionRepo;

    public List<Production> findAllLastProduction() {
        return productionRepo.findAllLastProduction();
    }


}

