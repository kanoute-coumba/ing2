package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.repository.ConditionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConditionsService {

    @Autowired
    private ConditionsRepo conditionsRepo;


    public void getValueTemperature(Integer valueTemperature, Integer id_room, Integer id_floor) {
       conditionsRepo.findByValueChambre(valueTemperature, id_room, id_floor);
    }
}
