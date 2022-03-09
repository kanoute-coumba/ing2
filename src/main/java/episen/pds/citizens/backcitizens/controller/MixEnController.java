package episen.pds.citizens.backcitizens.controller;


import episen.pds.citizens.backcitizens.model.ChoiceAlgo;
import episen.pds.citizens.backcitizens.model.MixEn;
import episen.pds.citizens.backcitizens.model.MixEnCapacityBySite;
import episen.pds.citizens.backcitizens.model.Test;
import episen.pds.citizens.backcitizens.service.MixEnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MixEnController {

    @Autowired
    private MixEnService mixEnService;
    private static final Logger logger = Logger.getLogger(MixEnController.class.getName());

    @GetMapping("/Mix")
    public Iterable<MixEn> getMixEn() {
        return mixEnService.getMixEn();
    }

    @GetMapping("/MixBySite")
    public Iterable<MixEnCapacityBySite> getMixEnBySite() {
        return mixEnService.getMixEnBySite();
    }

    @GetMapping("/CurrentAlgoChoice")
    public ChoiceAlgo getCurrentAlgoChoice() {
        return mixEnService.getCurrentAlgoChoice();
    }

    @PostMapping("/saveAlgoChoice")
    public void saveTest(@RequestBody ChoiceAlgo choiceAlgo) {
        mixEnService.saveAlgoChoice(choiceAlgo);
    }

    @GetMapping("/Algo")
    public HashMap<String,List<String>> getAlgo() {
        logger.info("algo");
        logger.info(""+mixEnService.getResultAlgoMix(1500));
        return mixEnService.getResultAlgoMix(1500);
    }
}
