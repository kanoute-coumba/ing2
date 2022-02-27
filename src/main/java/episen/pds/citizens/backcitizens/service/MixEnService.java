package episen.pds.citizens.backcitizens.service;



import episen.pds.citizens.backcitizens.model.*;
import episen.pds.citizens.backcitizens.repository.ChoiceAlgoRepo;
import episen.pds.citizens.backcitizens.repository.CurrentMixBySiteRepo;
import episen.pds.citizens.backcitizens.repository.CurrentMixRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
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

    public List<Integer> getResultAlgoMix(float consumption){
        //choice of algo in the database
        ChoiceAlgo choiceAlgo = choiceAlgoRepo.getChoiceAlgo();

        //production capacity for each energy (unit)
        //TODO modif : data in database or by another method with scope3
        float capacityOneSolarCentral = 200;
        float capacityOneWindTurbineCentral = 200;
        float capacityOneHydraulicCentral = 200;

        //number of plant equipment for each type of energy
        int nbSolarCentral = 0;
        int nbWindTurbineCentral = 0;
        int nbHydraulicCentral = 0;
        Iterable<MixEnBySite> listMixEnBySite = currentMixBySiteRepo.findEnergyProductionBySite();
        for(MixEnBySite m : listMixEnBySite){
            if(m.getName_building().equals("solaire")){
                nbSolarCentral += m.getNumber_equip();
            }
            if(m.getName_building().equals("eolienne")){
                nbWindTurbineCentral += m.getNumber_equip();
            }
            if(m.getName_building().equals("hydraulique")){
                nbHydraulicCentral += m.getNumber_equip();
            }
        }

        //the number of central to activate (result)
        int nbSolarCentralResult = 0;
        int nbWindTurbineCentralResult = 0;
        int nbHydraulicCentralResult = 0;
        List<Integer> l = new ArrayList<>();

        float production =0;

        // the different algorithms
        //Algo : preference
        //TODO return the result
        if(choiceAlgo.getChoice().equals("preference")){
            if(choiceAlgo.getPref1().equals("solaire")){
                while(production<consumption && nbSolarCentralResult<nbSolarCentral){
                    nbSolarCentralResult+=1;
                    production+=capacityOneSolarCentral;
                }
                if(choiceAlgo.getPref2().equals("eolienne") && production<consumption){
                    while(production<consumption && nbWindTurbineCentralResult<nbWindTurbineCentral){
                        nbWindTurbineCentralResult+=1;
                        production+=capacityOneWindTurbineCentral;
                    }
                    while(production<consumption && nbHydraulicCentralResult<nbHydraulicCentral){
                        nbHydraulicCentralResult+=1;
                        production+=capacityOneHydraulicCentral;
                    }
                }
                if(choiceAlgo.getPref2().equals("hydraulique") && production<consumption){
                    while(production<consumption && nbHydraulicCentralResult<nbHydraulicCentral){
                        nbHydraulicCentralResult+=1;
                        production+=capacityOneHydraulicCentral;
                    }
                    while(production<consumption && nbWindTurbineCentralResult<nbWindTurbineCentral){
                        nbWindTurbineCentralResult+=1;
                        production+=capacityOneWindTurbineCentral;
                    }
                }
                //TODO RESULTAT;
                l.add(nbSolarCentralResult);
                l.add(nbSolarCentral);
                l.add(nbWindTurbineCentralResult);
                l.add(nbWindTurbineCentral);
                l.add(nbHydraulicCentralResult);
                l.add(nbHydraulicCentral);
                return l;
            }

            if(choiceAlgo.getPref1().equals("eolienne")){
                while(production<consumption && nbWindTurbineCentralResult<nbWindTurbineCentral){
                    nbWindTurbineCentralResult+=1;
                    production+=capacityOneWindTurbineCentral;
                }

                if(choiceAlgo.getPref2().equals("solaire") && production<consumption){
                    while(production<consumption && nbSolarCentralResult<nbSolarCentral){
                        nbSolarCentralResult+=1;
                        production+=capacityOneSolarCentral;
                    }
                    while(production<consumption && nbHydraulicCentralResult<nbHydraulicCentral){
                        nbHydraulicCentralResult+=1;
                        production+=capacityOneHydraulicCentral;
                    }
                }
                if(choiceAlgo.getPref2().equals("hydraulique") && production<consumption){
                    while(production<consumption && nbHydraulicCentralResult<nbHydraulicCentral){
                        nbHydraulicCentralResult+=1;
                        production+=capacityOneHydraulicCentral;
                    }
                    while(production<consumption && nbSolarCentralResult<nbSolarCentral){
                        nbSolarCentralResult+=1;
                        production+=capacityOneSolarCentral;
                    }
                }
                //return RESULTAT;
            }

            if(choiceAlgo.getPref1().equals("hydraulique")){
                while(production<consumption && nbHydraulicCentralResult<nbHydraulicCentral){
                    nbHydraulicCentralResult+=1;
                    production+=capacityOneHydraulicCentral;
                }

                if(choiceAlgo.getPref2().equals("eolienne") && production<consumption){
                    while(production<consumption && nbWindTurbineCentralResult<nbWindTurbineCentral){
                        nbWindTurbineCentralResult+=1;
                        production+=capacityOneWindTurbineCentral;
                    }
                    while(production<consumption && nbSolarCentralResult<nbSolarCentral){
                        nbSolarCentralResult+=1;
                        production+=capacityOneSolarCentral;
                    }
                }
                if(choiceAlgo.getPref2().equals("solaire") && production<consumption){
                    while(production<consumption && nbSolarCentralResult<nbSolarCentral){
                        nbSolarCentralResult+=1;
                        production+=capacityOneSolarCentral;
                    }
                    while(production<consumption && nbWindTurbineCentralResult<nbWindTurbineCentral){
                        nbWindTurbineCentralResult+=1;
                        production+=capacityOneWindTurbineCentral;
                    }
                }
                //return RESULTAT;
            }

        }
        return l;
        /*
        // Algo : proportion user choice
        if(choiceAlgo.getChoice().equals("proportionchoice")){


        }

        // Algo : proportion equity
        if(choiceAlgo.getChoice().equals("proportionequity")){

        }

        // Algo : proportion weather report
        if(choiceAlgo.getChoice().equals("proportionweather")){

        }
*/
    }

}
