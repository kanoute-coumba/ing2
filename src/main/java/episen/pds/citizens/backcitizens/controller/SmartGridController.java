package episen.pds.citizens.backcitizens.controller;

import episen.pds.citizens.backcitizens.model.District;
import episen.pds.citizens.backcitizens.model.Production;
import episen.pds.citizens.backcitizens.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SmartGridController {

    @Autowired
    private MixEnService mixEnService;

    @Autowired
    private CentralService centralService;

    @Autowired
    private ProductionService productionService;

    @Autowired
    private DistrictService districtService;

    @GetMapping("/smartgrid")
    public Double smartgrid() {
        List<District> districts = districtService.readDistricts();
        double consumption = 0;
        double production = 0;
        for(District district : districts) {
            consumption += district.getConsumption();
            production += district.getProduction();
        }
        double balance = production - consumption;
        System.out.println("> Bilan énergétique de départ = " + balance);

        if (balance < 0) {
            balance = (float) Math.abs(balance);
            List<Integer> centrals = new ArrayList<>();

            HashMap<String, List<String>> mix = mixEnService.getResultAlgoMix((float) balance);
            Optional<String> key = mix.keySet().stream().findFirst();

            if (key.isPresent()) {
                switch(key.get()) {
                    case "pref":
                        System.out.println("Mix énergétique utilisé = pref");
                        balance = this.pref(mix.get("pref"), balance, centrals);
                        break;
                    case "prop":
                        System.out.println("Mix énergétique utilisé = prop");
                        balance = this.prop(mix.get("prop"), balance, centrals);
                        break;
                    default:
                        System.err.println("ERROR");
                }
            }

            if (balance > 0) {
                balance = this.activeCentralThermal(balance, centrals);
            }
            System.out.println("Nombre de générateur qui va être activé = " + centrals.size());
            System.out.println("Bilan énergétique d'arrivé = " + (balance * (-1)));

            centralService.updateResetStateOfCentral();
            centralService.updateStateOfCentral(centrals);
        }

        return balance * (-1);
    }

    private double pref(List<String> mix, double balance, List<Integer> centrals) {
        for(int i = 0; i < mix.size() && balance > 0; i++) {
            List<Production> productions = productionService.findAllProductionByCentralType(mix.get(i));
            for(int j = 0; j < productions.size() && balance > 0; j++) {
                centrals.add(productions.get(j).getIdCentral());
                balance -= productions.get(j).getCapacity();
            }
        }
        return balance;
    }

    private static double round(double number, int decimal) {
        return Math.round(number * Math.pow(10, decimal)) / Math.pow(10, decimal);
    }

    private double prop(List<String> mix, double balance, List<Integer> centrals) {
        String[] type = {"solaire", "eolienne", "hydraulique"};
        if(mix.size() == type.length) {
            for(int i = 0; i < mix.size() && balance > 0; i++) {
                double proportion = round(balance * Double.parseDouble(mix.get(i)) / 100, 2);
                List<Production> productions = productionService.findAllProductionByCentralType(type[i]);
                for(int j = 0; j < productions.size() && (balance * proportion) > 0; j++) {
                    centrals.add(productions.get(j).getIdCentral());
                    balance -= productions.get(j).getCapacity();
                }
            }
        }
        return balance;
    }

    private double activeCentralThermal(double balance, List<Integer> centrals) {
        List<Production> productions = productionService.findAllProductionByCentralType("thermique");
        for(int j = 0; j < productions.size() && balance > 0; j++) {
            centrals.add(productions.get(j).getIdCentral());
            balance -= productions.get(j).getCapacity();
        }
        return balance;
    }
}