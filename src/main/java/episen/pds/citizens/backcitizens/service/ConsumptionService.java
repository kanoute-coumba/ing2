package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.repository.ConsumptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumptionService {

        @Autowired
        private ConsumptionRepo consumptionRepo;

        public Iterable<Consumption> getConsumption() {
            return consumptionRepo.findConsoValue();
        }

    }


