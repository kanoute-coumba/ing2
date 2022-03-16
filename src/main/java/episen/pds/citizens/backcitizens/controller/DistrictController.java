package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.District;
import episen.pds.citizens.backcitizens.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @GetMapping("/districts")
    public List<District> readDistricts() {
        return districtService.readDistricts();
    }
}
