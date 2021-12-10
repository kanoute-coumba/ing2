package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.Attribution;
import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.repository.ConsumptionRepo;
import episen.pds.citizens.backcitizens.repository.AttributionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OverrunService {

        @Autowired
        private ConsumptionRepo consumptionRepo;
        @Autowired
        private AttributionRepo attributionRepo;

        public Iterable<Consumption> getConsumption() {
            return consumptionRepo.findWholeConsumption();
        }
        public Iterable<Attribution> getAttribution() { return attributionRepo.findAttribution();
    }


    }


