package episen.pds.citizens.backcitizens.controller;


import episen.pds.citizens.backcitizens.model.MixEn;
import episen.pds.citizens.backcitizens.model.MixEnCapacityBySite;
import episen.pds.citizens.backcitizens.service.MixEnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MixEnController {

    @Autowired
    private MixEnService mixEnService;
    private static final Logger logger = Logger.getLogger(MixEnController.class.getName());

    @GetMapping("/Mix")
    public Iterable<MixEn> getMixEn() {
        logger.info("current mix return");
        return mixEnService.getMixEn();
    }

    @GetMapping("/MixBySite")
    public Iterable<MixEnCapacityBySite> getMixEnBySite() {
        logger.info("current mix return");
        return mixEnService.getMixEnBySite();
    }
}
