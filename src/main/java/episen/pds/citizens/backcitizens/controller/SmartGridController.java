package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.BuildingCentral;
import episen.pds.citizens.backcitizens.service.BuildingCentralService;
import episen.pds.citizens.backcitizens.service.CentralService;
import episen.pds.citizens.backcitizens.service.MixEnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SmartGridController {

    @Autowired
    private MixEnService mixEnService;

    @Autowired
    private BuildingCentralService buildingCentralService;

    @Autowired
    private CentralService centralService;

    @GetMapping("/smartgrid")
    public Double smartgrid() {
        centralService.updateResetStateOfCentral();
        double balance = randomRange(0, 2000);
        HashMap<String, List<String>> mix = mixEnService.getResultAlgoMix((float) balance);
        Optional<String> key = mix.keySet().stream().findFirst();
        if (key.isPresent()) {
            switch(key.get()) {
                case "pref":
                    System.out.println("pref");
                    break;
                case "prop":
                    System.out.println("prop");
                    Double solar = round(balance * Double.parseDouble(mix.get("prop").get(0)) / 100, 2);
                    Double wind = round(balance * Double.parseDouble(mix.get("prop").get(1)) / 100, 2);
                    Double hydraulic = round(balance * Double.parseDouble(mix.get("prop").get(2)) / 100, 2);
                    this.prop(solar, wind, hydraulic);
                    break;
                default:
                    System.err.println("ERROR");
            }
        }
        return balance;
    }

    private static double randomRange(int min, int max) {
        return round((Math.random() * (max - min)) + min, 2);
    }

    private static double round(double number, int decimal) {
        return Math.round(number * Math.pow(10, decimal)) / Math.pow(10, decimal);
    }

    private void prop(Double solar, Double wind, Double hydraulic) {
        System.out.println("Total = " + solar + wind + hydraulic);
        System.out.println("solar = " + solar);
        System.out.println("wind = " + wind);
        System.out.println("hydraulic = " + hydraulic);
        List<BuildingCentral> centrals = buildingCentralService.readBuildingsTypeCentral();
        List<BuildingCentral> centralsSolar = centrals.stream().filter(central -> central.getType().equals("solaire")).collect(Collectors.toList());
        List<BuildingCentral> centralsWind = centrals.stream().filter(central -> central.getType().equals("eolienne")).collect(Collectors.toList());
        List<BuildingCentral> centralsHydraulic = centrals.stream().filter(central -> central.getType().equals("hydraulique")).collect(Collectors.toList());
        List<BuildingCentral> centralsThermal = centrals.stream().filter(central -> central.getType().equals("thermique")).collect(Collectors.toList());
        List<Integer> id = new ArrayList<>();

        for(int i = 0; i < centralsSolar.size() && solar > 0; i++) {
            solar -= centralsSolar.get(i).getCapacity();
            id.add(centralsSolar.get(i).getId());
        }

        for(int i = 0; i < centralsWind.size() && wind > 0; i++) {
            wind -= centralsWind.get(i).getCapacity();
            id.add(centralsWind.get(i).getId());
        }

        for(int i = 0; i < centralsHydraulic.size() && hydraulic > 0; i++) {
            wind -= centralsHydraulic.get(i).getCapacity();
            id.add(centralsHydraulic.get(i).getId());
        }

        double total = solar + wind + hydraulic;
        if(total > 0) {
            for(int i = 0; i < centralsThermal.size() && total > 0; i++) {
                total -= centralsThermal.get(i).getCapacity();
                id.add(centralsThermal.get(i).getId());
            }
        }
        System.out.println("after solar = " + solar);
        System.out.println("after wind = " + wind);
        System.out.println("after hydraulic = " + hydraulic);
        System.out.println("after Total = " + solar + wind + hydraulic);
        centralService.updateStateOfCentral(id);
    }
}
