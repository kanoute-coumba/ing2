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

    @GetMapping("/Algo/{consumption}")
    public HashMap<String,List<String>> getAlgo(@PathVariable("consumption") float consumption) {
        logger.info("algo");
        logger.info(""+mixEnService.getResultAlgoMix(consumption));
        return mixEnService.getResultAlgoMix(consumption);
    }

    @PostMapping("/simulationEconomicCost")
    public HashMap<String,List<Double>> getGraphDataEconomicCost(@RequestBody HashMap<String,String> simu){
        return mixEnService.getGraphDataEconomicCost(simu);
    }

    @GetMapping("/graphDataEnvironmentalCost")
    public HashMap<String,List<Double>> getGraphDataEnvironmentalCost(){
        return mixEnService.getGraphDataEnvironmentalCost();
    }
}
