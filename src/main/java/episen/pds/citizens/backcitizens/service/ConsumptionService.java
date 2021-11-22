package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.repository.ConsumptionRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class ConsumptionService {

        @Autowired
        private ConsumptionRepo consumptionRepo;

    public ConsumptionService(ConsumptionRepo consumptionRepo) {
        this.consumptionRepo = consumptionRepo;
    }
        public Iterable<Consumption> getConsumption() {
            return consumptionRepo.findAll();
        }

    }


