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

}
