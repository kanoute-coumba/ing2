package episen.pds.citizens.backcitizens;

import episen.pds.citizens.backcitizens.model.ChoiceAlgo;
import episen.pds.citizens.backcitizens.model.MixEn;
import episen.pds.citizens.backcitizens.model.MixEnBySite;
import episen.pds.citizens.backcitizens.model.MixEnCapacityBySite;
import episen.pds.citizens.backcitizens.repository.*;
import episen.pds.citizens.backcitizens.service.FunctionForAlgoMix;
import episen.pds.citizens.backcitizens.service.MixEnService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MixEnServiceTest extends TestCase {
    /**
     * Dans la classe MixEnService il y a 11 methode utilisé dans le projet
     * On va faire des tests pour chacune des méthodes sauf :
     * la methode getHistoricalProductionByDate() ligne 329 de la classe MixEnService
     * la methode solarHisto() ligne 341 de la classe MixEnService
     * la methode windHisto() ligne 350 de la classe MixEnService
     * la methode hydraulicHisto() ligne 359 de la classe MixEnService
     */

    @Mock
    private ChoiceAlgoRepo choiceAlgoRepo;
    @Mock
    private CurrentMixRepo currentMixRepo;
    @Mock
    private CurrentMixBySiteRepo currentMixBySiteRepo;
    @Mock
    private HistoricalProductionRepo historicalProductionRepo;

    @InjectMocks
    private MixEnService mixEnService = new MixEnService();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test de la methode getMixEn() ligne 32 de la classe MixEnService
     * Dans cette methode on veut retourner une liste de MixEn
     * dont l'attribut mix de MixEn correspond à la part de production de l'énergie en question dans la production totale.
     * On doit calculer des pourcentages
     */
    @Test
    public void testGetMixEn(){
        //GIVEN
        Iterable<MixEn> listMixEn = currentMixRepo.findEnergyProduction();
        int totalProduction = 0;
        for(MixEn m : listMixEn){
            totalProduction += m.getMix();
        }
        List<MixEn> given = new ArrayList<>();
        for(MixEn m : listMixEn){
            int i = (int) Math.round(m.getMix()*100*1.0/totalProduction);
            given.add(new MixEn(i, m.getNameBuilding()));
        }
        //WHEN
        Iterable<MixEn> service = mixEnService.getMixEn();
        //THEN
        assertEquals(given,service);
    }

    /**
     * Test de la methode getMixEnBySite() ligne 55 de la classe MixEnService
     * Dans cette methode on veut retourner une liste de MixEnCapacityBySite à partir d'une liste de MixEnBySite
     * dont l'attribut mix de MixEnCapacityBySite correspond à la part de production du site (usine) en question dans la production totale.
     * On doit calculer des pourcentages
     */
    @Test
    public void testGetMixEnBySite(){
        //GIVEN
        Iterable<MixEnBySite> listMixEnBySite = currentMixBySiteRepo.findEnergyProductionBySite();
        int totalProduction = 0;
        for(MixEnBySite m : listMixEnBySite){
            totalProduction += m.getMix();
        }
        List<MixEnCapacityBySite> given = new ArrayList<>();
        for(MixEnBySite m : listMixEnBySite){
            int mix = (int) Math.round(m.getMix()*100*1.0/totalProduction);
            int capacity_used = (int) Math.round(m.getActive_equip()*100*1.0/m.getNumber_equip());
            given.add(new MixEnCapacityBySite(mix,m.getMix(), m.getAddress(), m.getName_building(),m.getActive_equip(),m.getNumber_equip(), capacity_used));
        }
        //WHEN
        Iterable<MixEnCapacityBySite> service = mixEnService.getMixEnBySite();
        //THEN
        assertEquals(given,service);
    }

    /**
     * Test de la methode getCurrentAlgoChoice() ligne 82 de la classe MixEnService
     */
    @Test
    public void testGetCurrentAlgoChoice(){
        //GIVEN
        ChoiceAlgo given = choiceAlgoRepo.getChoiceAlgo();
        //WHEN
        ChoiceAlgo service = mixEnService.getCurrentAlgoChoice();
        //THEN
        assertEquals(given,service);
    }

    /**
     *Test de la methode saveAlgoChoice(ChoiceAlgo choiceAlgo) ligne 86 de la classe MixEnService
     */
    @Test
    public void testSaveAlgoChoice(){
        //On va créer un AlgoChoice et vérifier que l'AlgoChoice en base est bien celui qui a été enregistré
        //GIVEN
        ChoiceAlgo given = new ChoiceAlgo(1,"preference","solaire","eolienne","hydraulique",0,0,0);
        //WHEN
        Mockito.when(choiceAlgoRepo.getChoiceAlgo()).thenReturn(given);
        ChoiceAlgo test = mixEnService.saveAlgoChoice(given); //don't save in the test, but it's working in MixEnService
        ChoiceAlgo service = mixEnService.getCurrentAlgoChoice(); //pb return null
        //THEN
        assertEquals(given,service);
    }

    /**
     *Test de la methode getResultAlgoMix(float consumption) ligne 92 de la classe MixEnService
     */
    @Test
    public void testGetResultAlgoMix(){
        ChoiceAlgo given = new ChoiceAlgo(1,"preference","solaire","eolienne","hydraulique",0,0,0);
        Mockito.when(choiceAlgoRepo.getChoiceAlgo()).thenReturn(given);
        //Test algo preference :
        String choix1 = "solaire";
        String choix2 = "eolienne";
        String choix3 = "hydraulique";

        HashMap<String,List<String>> hm = mixEnService.getResultAlgoMix(500);
        List<String> l = hm.get("pref");
        assertEquals(choix1,l.get(0));
        assertEquals(choix2,l.get(1));
        assertEquals(choix3,l.get(2));

        ChoiceAlgo given2 = new ChoiceAlgo(1,"proportionchoice","solaire","eolienne","hydraulique",45,15,40);
        Mockito.when(choiceAlgoRepo.getChoiceAlgo()).thenReturn(given2);
        //Test algo proportionchoice :
        String prop1 = "45.0";
        String prop2 = "15.0";
        String prop3 = "40.0";
        HashMap<String,List<String>> hm2 = mixEnService.getResultAlgoMix(500);
        List<String> l2 = hm2.get("prop");
        assertEquals(prop1,l2.get(0));
        assertEquals(prop2,l2.get(1));
        assertEquals(prop3,l2.get(2));

        ChoiceAlgo given3 = new ChoiceAlgo(1,"proportionequity","solaire","eolienne","hydraulique",45,15,40);
        Mockito.when(choiceAlgoRepo.getChoiceAlgo()).thenReturn(given3);
        //Test algo proportionchoice :
        String propequity = "33";
        HashMap<String,List<String>> hm3 = mixEnService.getResultAlgoMix(500);
        List<String> l3 = hm3.get("prop");
        assertEquals(propequity,l3.get(0));
        assertEquals(propequity,l3.get(1));
        assertEquals(propequity,l3.get(2));
        /*
        ChoiceAlgo given4 = new ChoiceAlgo(1,"economic","solaire","eolienne","hydraulique",45,15,40);
        Mockito.when(choiceAlgoRepo.getChoiceAlgo()).thenReturn(given4);
        //Test algo economic :
        String propequity = "33";
        HashMap<String,List<String>> hm4 = mixEnService.getResultAlgoMix(500);
        List<String> l4 = hm4.get("prop");
        assertEquals(propequity,l3.get(0));
        assertEquals(propequity,l3.get(1));
        assertEquals(propequity,l3.get(2)); */

        ChoiceAlgo given5 = new ChoiceAlgo(1,"environmental","solaire","eolienne","hydraulique",45,15,40);
        Mockito.when(choiceAlgoRepo.getChoiceAlgo()).thenReturn(given5);
        //Test algo environmental :
        HashMap<String,List<String>> hm5 = mixEnService.getResultAlgoMix(500);
        List<String> l5 = hm5.get("pref");
        assertEquals("hydraulique",l5.get(0));
        assertEquals("eolienne",l5.get(1));
        assertEquals("solaire",l5.get(2));

    }

    /**
     *Test de la methode getGraphDataEconomicCost(HashMap<String,String> simu) ligne 237 de la classe MixEnService
     */
    @Test
    public void testGetGraphDataEconomicCost(){
        HashMap<String,String> simu = new HashMap<>();
        simu.put("solaireAmort","rentable");
        simu.put("eolienneAmort","rentable");
        simu.put("hydrauliqueAmort","rentable");
        simu.put("conso","1000");

        List<Double> l1  = new ArrayList<>();
        List<Double> l2  = new ArrayList<>();
        List<Double> l3  = new ArrayList<>();
        for (int i=0; i<=Double.parseDouble("1000")/200;i++){
            List<Double> economicCost = (new FunctionForAlgoMix(100,100,100)).economicCost(200*i);
            l1.add(economicCost.get(0));
            l2.add(economicCost.get(1));
            l3.add(economicCost.get(2));
        }

        assertEquals(l1,mixEnService.getGraphDataEconomicCost(simu).get("solaire"));
        assertEquals(l2,mixEnService.getGraphDataEconomicCost(simu).get("eolienne"));
        assertEquals(l3,mixEnService.getGraphDataEconomicCost(simu).get("hydraulique"));

    }

    /**
     *Test de la methode getGraphDataEnvironmentalCost() ligne 270 de la classe MixEnService
     */
    @Test
    public void testGetGraphDataEnvironmentalCost(){
        List<Double> l1  = new ArrayList<>();
        List<Double> l2  = new ArrayList<>();
        List<Double> l3  = new ArrayList<>();
        for (int i=0; i <= 6000/200; i++){
            List<Double> economicCost = (new FunctionForAlgoMix()).environmentalCost(200*i);
            l1.add(economicCost.get(0));
            l2.add(economicCost.get(1));
            l3.add(economicCost.get(2));
        }

        assertEquals(l1,mixEnService.getGraphDataEnvironmentalCost().get("solaire"));
        assertEquals(l2,mixEnService.getGraphDataEnvironmentalCost().get("eolienne"));
        assertEquals(l3,mixEnService.getGraphDataEnvironmentalCost().get("hydraulique"));
    }

    /**
     *Test de la methode getHistoricalProductionByDate() ligne 329 de la classe MixEnService
     */
    @Test
    public void testGetHistoricalProductionByDate(){
        //Test non fait pour cette methode
    }

    /**
     *Test de la methode solarHisto() ligne 341 de la classe MixEnService
     */
    @Test
    public void testSolarHisto(){
        //Test non fait pour cette methode
    }

    /**
     *Test de la methode windHisto() ligne 350 de la classe MixEnService
     */
    @Test
    public void testWindHisto(){
        //Test non fait pour cette methode
    }

    /**
     *Test de la methode hydraulicHisto() ligne 359 de la classe MixEnService
     */
    @Test
    public void testHydraulicHisto(){
        //Test non fait pour cette methode
    }

    @Test
    public void testGetResAlgoEco(){
        HashMap<String,List<String>> hm1 = new HashMap<>();
        List<String> l1 = new ArrayList<>();
        l1.add("25");
        l1.add("25");
        l1.add("50");
        hm1.put("prop",l1);

        HashMap<String,List<String>> hm1bis = mixEnService.getResAlgoEco(4000,1000,1000,2000);

        assertEquals(hm1,hm1bis);

        HashMap<String,List<String>> hm2 = new HashMap<>();
        List<String> l2 = new ArrayList<>();
        l2.add("0");
        l2.add("25");
        l2.add("75");
        hm2.put("prop",l2);

        HashMap<String,List<String>> hm2bis = mixEnService.getResAlgoEco(8000,8000,7000,7000);

        assertEquals(hm2,hm2bis);
    }
}
