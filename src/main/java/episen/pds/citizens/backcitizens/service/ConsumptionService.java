package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.model.Test;
import episen.pds.citizens.backcitizens.repository.ConsumptionRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ConsumptionService {

        @Autowired
        private ConsumptionRepo consumptionRepo;

        public Optional<Consumption> getTestId(final int id) {
            return consumptionRepo.findById( id);
        }

        public Iterable<Consumption> getTest() {
            return consumptionRepo.findAll();
        }

    }


