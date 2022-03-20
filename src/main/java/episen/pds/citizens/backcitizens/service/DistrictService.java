package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.District;
import episen.pds.citizens.backcitizens.repository.DistrictRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepo districtRepo;

    public List<District> readDistricts() {
        return districtRepo.findAll();
    }
}