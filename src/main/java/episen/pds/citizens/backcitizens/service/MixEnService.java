package episen.pds.citizens.backcitizens.service;



import episen.pds.citizens.backcitizens.model.MixEn;
import episen.pds.citizens.backcitizens.model.MixEnBySite;
import episen.pds.citizens.backcitizens.model.MixEnCapacityBySite;
import episen.pds.citizens.backcitizens.repository.CurrentMixBySiteRepo;
import episen.pds.citizens.backcitizens.repository.CurrentMixRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class MixEnService {

    @Autowired
    private CurrentMixRepo currentMixRepo;
    @Autowired
    private CurrentMixBySiteRepo currentMixBySiteRepo;
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
        List<MixEn> percentageMixEn = new ArrayList<MixEn>();
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

    //method for algo
    public void getResultAlgoMix(float consumption){
        //choix de l'algo et paraméttre

        //capacité de prod pour chaque énergie(unité)
        float capacityOneSolarCentral = ;
        float capacityOneWindTurbineCentral = ;
        float capacityOneHydraulicCentral = ;

        //nb d'équipement des usines pour chaque type d'énergie
        int nbSolarCentral = ;
        int nbWindTurbineCentral = ;
        int nbHydraulicCentral = ;

        //nb de central à activer (résultat)
        int nbSolarCentralResult = ;
        int nbWindTurbineCentralResult = ;
        int nbHydraulicCentralResult = ;

        float production =0;

        // selon le choix différent algo
        //préférence
        if(){

            if(choi1 = "Solaire"){
                while(production<consumption || nbSolarCentralResult<nbSolarCentral){
                    nbSolarCentralResult+=1;
                    production+=capacityOneSolarCentral;
                }
                if(choix2 = "Eolienne" && production<consumption){
                    while(production<consumption || nbWindTurbineCentralResult<nbWindTurbineCentral){
                        nbWindTurbineCentralResult+=1;
                        production+=capacityOneWindTurbineCentral;
                    }
                }
                if(choix2 = "Hydraulique" && production<consumption){
                    while(production<consumption || nbHydraulicCentralResult<nbHydraulicCentral){
                        nbHydraulicCentralResult+=1;
                        production+=capacityOneHydraulicCentral;
                    }
                }
                return RESULTAT;
            }

            if(choi1 = "Eolienne"){
                while(production<consumption || nbWindTurbineCentralResult<nbWindTurbineCentral){
                    nbWindTurbineCentralResult+=1;
                    production+=capacityOneWindTurbineCentral;
                }

                if(choix2 = "Solaire" && production<consumption){
                    while(production<consumption || nbSolarCentralResult<nbSolarCentral){
                        nbSolarCentralResult+=1;
                        production+=capacityOneSolarCentral;
                    }
                }
                if(choix2 = "Hydraulique" && production<consumption){
                    while(production<consumption || nbHydraulicCentralResult<nbHydraulicCentral){
                        nbHydraulicCentralResult+=1;
                        production+=capacityOneHydraulicCentral;
                    }
                }
                return RESULTAT;
            }

            if(choi1 = "Hydraulique"){
                while(production<consumption || nbHydraulicCentralResult<nbHydraulicCentral){
                    nbHydraulicCentralResult+=1;
                    production+=capacityOneHydraulicCentral;
                }

                if(choix2 = "Eolienne" && production<consumption){
                    while(production<consumption || nbWindTurbineCentralResult<nbWindTurbineCentral){
                        nbWindTurbineCentralResult+=1;
                        production+=capacityOneWindTurbineCentral;
                    }
                }
                if(choix2 = "Solaire" && production<consumption){
                    while(production<consumption || nbSolarCentralResult<nbSolarCentral){
                        nbSolarCentralResult+=1;
                        production+=capacityOneSolarCentral;
                    }
                }
                return RESULTAT;
            }

        }
        //proportion
        if(){

        }

    }

}
