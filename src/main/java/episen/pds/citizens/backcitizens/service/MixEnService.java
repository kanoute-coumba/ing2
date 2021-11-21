package episen.pds.citizens.backcitizens.service;


import episen.pds.citizens.backcitizens.model.MixEn;
import episen.pds.citizens.backcitizens.repository.CurrentMixRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MixEnService {

    @Autowired
    private CurrentMixRepo currentMixRepo;

    public Iterable<MixEn> getMixEn() {

        return currentMixRepo.findEnergyProduction();
    }

}
