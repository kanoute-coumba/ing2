package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.Attribution;
import episen.pds.citizens.backcitizens.repository.OverrunRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OverrunService {

        @Autowired
        private OverrunRepo overrunRepo;

        public Iterable<Attribution> getOverrun() {
            return overrunRepo.findWholeConsumption();
        }

    }


