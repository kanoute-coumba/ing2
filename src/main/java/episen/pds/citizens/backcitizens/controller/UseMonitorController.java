package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.service.UseMonitorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UseMonitorController {
    private UseMonitorService useMonitorService;

}
