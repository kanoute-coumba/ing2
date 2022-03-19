package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.repository.CentralRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentralService {
    @Autowired
    private CentralRepo centralRepo;

    public void updateStateOfCentral(List<Integer> id) {
        centralRepo.updateStateOfCentral(id);
    }

    public void updateResetStateOfCentral() {
        centralRepo.updateResetStateOfCentral();
    }
}
