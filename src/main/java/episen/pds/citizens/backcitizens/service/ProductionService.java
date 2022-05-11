package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.Production;
import episen.pds.citizens.backcitizens.repository.ProductionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductionService {
    @Autowired
    private ProductionRepo productionRepo;

    public List<Production> findAllProductionByCentralType(String type) {
        return productionRepo.findAllProductionByCentralType(type);
    }

    public Production findProductionByIdBuilding(int idb){
        Production production = new Production(0,Timestamp.from(Instant.now()),0,0);
        ArrayList<Production> arrayList = productionRepo.findCurrentProductionByBuilding(idb);
        for(Production p : arrayList){
            production.value += p.value;
        }
        production.value = (int) production.value;
        return production;
    }
}

