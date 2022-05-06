package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.Production;
import episen.pds.citizens.backcitizens.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductionController {
    @Autowired
    private ProductionService productionService;

    @GetMapping("/findAllLastProduction")
    public List<Production> findAllLastProduction() {
        return productionService.findAllLastProduction();
    }

    @GetMapping("/currentProductionByIdBuilding/{idb}")
    public Production finCurrentProductionByIdBuilding(@PathVariable("idb") int idb){
        return productionService.findProductionByIdBuilding(idb);
    }
}
