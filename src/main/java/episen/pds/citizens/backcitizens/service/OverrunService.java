package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.Attribution;
import episen.pds.citizens.backcitizens.model.ConsumptionDay;
import episen.pds.citizens.backcitizens.repository.ConsumptionDayRepo;
import episen.pds.citizens.backcitizens.repository.AttributionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OverrunService {

        @Autowired
        private ConsumptionDayRepo consumptionRepo;
        @Autowired
        private AttributionRepo attributionRepo;

        public Iterable<ConsumptionDay> getConsumption() {
            return consumptionRepo.findConsoPerEquipementPerDay();
        }

        public Iterable<Attribution> getAttribution() {
            return attributionRepo.findAttribution();
        }
        public Iterable<ConsumptionDay> getPeakDay() {
        return consumptionRepo.findPeakDay();
    }



    }


