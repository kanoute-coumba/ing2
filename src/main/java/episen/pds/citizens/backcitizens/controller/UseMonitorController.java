package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.service.UseMonitorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UseMonitorController {
    private UseMonitorService useMonitorService;

    @GetMapping("/getConsumptionByBuilding")
    public Iterable<Consumption> getConsumptionByBuilding(int id_building) {
        return useMonitorService.getConsumptionByBuilding(id_building);
    }
}
