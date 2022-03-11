package episen.pds.citizens.backcitizens.service;



import episen.pds.citizens.backcitizens.model.*;
import episen.pds.citizens.backcitizens.repository.ChoiceAlgoRepo;
import episen.pds.citizens.backcitizens.repository.CurrentMixBySiteRepo;
import episen.pds.citizens.backcitizens.repository.CurrentMixRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.logging.Logger;

@Service
public class MixEnService {

    @Autowired
    private CurrentMixRepo currentMixRepo;
    @Autowired
    private CurrentMixBySiteRepo currentMixBySiteRepo;
    @Autowired
    private ChoiceAlgoRepo choiceAlgoRepo;
    private static final Logger logger = Logger.getLogger(MixEnService.class.getName());

    //method for current mix
    public Iterable<MixEn> getMixEn() {
        // current production of each energy
        Iterable<MixEn> listMixEn = currentMixRepo.findEnergyProduction();
        // total current production
        int totalProduction = 0;

        for(MixEn m : listMixEn){
            totalProduction += m.getMix();
        }
        logger.info(""+totalProduction);

        // list of percentage of the current production for each energy
        List<MixEn> percentageMixEn = new ArrayList<>();
        for(MixEn m : listMixEn){
            int i = (int) Math.round(m.getMix()*100*1.0/totalProduction);
            MixEn mix = new MixEn(i, m.getNameBuilding());
            percentageMixEn.add(mix);
            logger.info(mix.toString());
        }
        return percentageMixEn;
    }

    //method for current mix
    public Iterable<MixEnCapacityBySite> getMixEnBySite(){
        // current production of each site
        Iterable<MixEnBySite> listMixEnBySite = currentMixBySiteRepo.findEnergyProductionBySite();
        // total current production
        int totalProduction = 0;

        for(MixEnBySite m : listMixEnBySite){
            totalProduction += m.getMix();
        }
        logger.info(""+totalProduction);

        List<MixEnCapacityBySite> listPercentageMixEnBySite = new ArrayList<>();
        for(MixEnBySite m : listMixEnBySite){

            int mix = (int) Math.round(m.getMix()*100*1.0/totalProduction);
            int capacity_used = (int) Math.round(m.getActive_equip()*100*1.0/m.getNumber_equip());

            MixEnCapacityBySite mixEnCapacityBySite = new MixEnCapacityBySite(mix,m.getMix(), m.getAddress(), m.getName_building(),m.getActive_equip(),m.getNumber_equip(), capacity_used);
            listPercentageMixEnBySite.add(mixEnCapacityBySite);

            logger.info(mixEnCapacityBySite.toString());
        }
        return listPercentageMixEnBySite;

    }

    //method : Current Algo Choice
    public ChoiceAlgo getCurrentAlgoChoice(){
        return choiceAlgoRepo.getChoiceAlgo();
    }
    //method : Save Algo Choice
    public ChoiceAlgo saveAlgoChoice(ChoiceAlgo choiceAlgo) {
        return choiceAlgoRepo.save(choiceAlgo);
    }

    //method for algo

    public HashMap<String,List<String>> getResultAlgoMix(float consumption){
        //choice of algo in the database
        ChoiceAlgo choiceAlgo = choiceAlgoRepo.getChoiceAlgo();

        //production capacity for each energy (unit)
        //TODO modif : data in database or by another method with scope3
        float capacityOneSolarCentral = 200;
        float capacityOneWindTurbineCentral = 200;
        float capacityOneHydraulicCentral = 200;

        // result method
        HashMap<String, List<String>> result = new HashMap<>();

        // the different algorithms
        //Algo : preference
        if(choiceAlgo.getChoice().equals("preference")){
            List<String> prefList= new ArrayList<>();
            prefList.add(choiceAlgo.getPref1());
            prefList.add(choiceAlgo.getPref2());
            prefList.add(choiceAlgo.getPref3());
            result.put("pref",prefList);
            return result;
        }

        // /*
        // Algo : proportion user choice
        if(choiceAlgo.getChoice().equals("proportionchoice")){
            List<String> propList= new ArrayList<>();
            propList.add(""+choiceAlgo.getProp1());
            propList.add(""+choiceAlgo.getProp2());
            propList.add(""+choiceAlgo.getProp3());
            result.put("prop",propList);
            return result;

        }

        // Algo : proportion equity
        if(choiceAlgo.getChoice().equals("proportionequity")){
            List<String> propList= new ArrayList<>();
            propList.add("33");
            propList.add("33");
            propList.add("33");
            result.put("prop",propList);
            return result;
        }

        // Algo : proportion weather report
        if(choiceAlgo.getChoice().equals("preferenceweather")){ //TODO
            List<String> prefList= new ArrayList<>();
            //default val
            prefList.add("solaire");
            prefList.add("eolienne");
            prefList.add("hydraulique");

            result.put("pref",prefList);
            return result;
        }

        // Algo : economic
        if(choiceAlgo.getChoice().equals("economic")){
            FunctionForAlgoMix function = new FunctionForAlgoMix();
            List<Double> economicCost = function.economicCost(consumption);
            Double s = economicCost.get(0);
            Double w = economicCost.get(1);
            Double h = economicCost.get(2);
            List<String> prefList= new ArrayList<>();
            if(s<=w && s<=h){
                prefList.add("Solaire");
                if (w<=h){
                    prefList.add("Eolienne");
                    prefList.add("Hydraulique");
                }else{
                    prefList.add("Hydraulique");
                    prefList.add("Eolienne");
                }
            }
            if(w<=s && w<=h){
                prefList.add("Eolienne");
                if (s<=h){
                    prefList.add("Solaire");
                    prefList.add("Hydraulique");
                }else{
                    prefList.add("Hydraulique");
                    prefList.add("Solaire");
                }
            }
            if(h<=s && h<=w){
                prefList.add("Hydraulique");
                if (w<=s){
                    prefList.add("Eolienne");
                    prefList.add("Solaire");
                }else{
                    prefList.add("Solaire");
                    prefList.add("Eolienne");
                }
            }
            result.put("pref",prefList);
            return result;
        }

        // Algo : environmental
        //if(choiceAlgo.getChoice().equals("environmental"))
        else{
            FunctionForAlgoMix function = new FunctionForAlgoMix();
            List<Double> environmentalCost = function.environmentalCost(consumption);
            Double s = environmentalCost.get(0);
            Double w = environmentalCost.get(1);
            Double h = environmentalCost.get(2);
            List<String> prefList= new ArrayList<>();
            if(s<=w && s<=h){
                prefList.add("Solaire");
                if (w<=h){
                    prefList.add("Eolienne");
                    prefList.add("Hydraulique");
                }else{
                    prefList.add("Hydraulique");
                    prefList.add("Eolienne");
                }
            }
            if(w<=s && w<=h){
                prefList.add("Eolienne");
                if (s<=h){
                    prefList.add("Solaire");
                    prefList.add("Hydraulique");
                }else{
                    prefList.add("Hydraulique");
                    prefList.add("Solaire");
                }
            }
            if(h<=s && h<=w){
                prefList.add("Hydraulique");
                if (w<=s){
                    prefList.add("Eolienne");
                    prefList.add("Solaire");
                }else{
                    prefList.add("Solaire");
                    prefList.add("Eolienne");
                }
            }
            result.put("pref",prefList);
            return result;
        }

    }

    public HashMap<String,List<Double>> getGraphDataEconomicCost(HashMap<String,String> simu){
        HashMap<String,List<Double>> graphData = new HashMap<>();
        float installationSolarYear =0;
        float installationWindTurbineYear =0;
        float installationHydraulicYear =0;
        if(simu.get("solaireAmort").equals("rentable")){installationSolarYear=100;}
        if(simu.get("eolienneAmort").equals("rentable")){installationWindTurbineYear=100;}
        if(simu.get("hydrauliqueAmort").equals("rentable")){installationHydraulicYear=100;}
        FunctionForAlgoMix function = new FunctionForAlgoMix(installationSolarYear,installationWindTurbineYear,installationHydraulicYear);

        List<Double> abs  = new ArrayList<>();
        for (int i=0; i<=Double.parseDouble(simu.get("conso"))/200;i++){
            abs.add((double) (200 * i));
        }
        List<Double> l1  = new ArrayList<>();
        List<Double> l2  = new ArrayList<>();
        List<Double> l3  = new ArrayList<>();
        for (int i=0; i<=Double.parseDouble(simu.get("conso"))/200;i++){
            List<Double> economicCost = function.economicCost(200*i);
            l1.add(economicCost.get(0));
            l2.add(economicCost.get(1));
            l3.add(economicCost.get(2));
        }

        graphData.put("abs",abs);
        graphData.put("solaire",l1);
        graphData.put("eolienne",l2);
        graphData.put("hydraulique",l3);

        return graphData;
    }

    //
    public HashMap<String,List<Double>> getGraphDataEnvironmentalCost(){
        HashMap<String,List<Double>> graphData = new HashMap<>();
        float conso = 6000;
        FunctionForAlgoMix function = new FunctionForAlgoMix();

        List<Double> abs  = new ArrayList<>();
        for (int i=0; i <= conso/200; i++){
            abs.add((double) (200 * i));
        }
        List<Double> l1  = new ArrayList<>();
        List<Double> l2  = new ArrayList<>();
        List<Double> l3  = new ArrayList<>();
        for (int i=0; i <= conso/200; i++){
            List<Double> environmentCost = function.environmentalCost(200*i);
            l1.add(environmentCost.get(0));
            l2.add(environmentCost.get(1));
            l3.add(environmentCost.get(2));
        }

        graphData.put("abs",abs);
        graphData.put("solaire",l1);
        graphData.put("eolienne",l2);
        graphData.put("hydraulique",l3);

        return graphData;
    }
}
