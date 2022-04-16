package episen.pds.citizens.backcitizens;


import episen.pds.citizens.backcitizens.model.Consumption;
import episen.pds.citizens.backcitizens.service.ConsumptionService;
import junit.framework.TestCase;

import java.util.ArrayList;

public class ConsumptionServiceTest extends TestCase {
    ConsumptionService consumptionService = new ConsumptionService();

    public void testCleanList(){
        ArrayList<Consumption> arrayList = new ArrayList<>();
        Consumption co1 = new Consumption(1,1.0,1,1);
        Consumption co2 = new Consumption(1,1.0,2,1);
        Consumption co3 = new Consumption(1,1.0,3,1);
        Consumption co4 = new Consumption(1,3.0,4,1);
        arrayList.add(co1);
        arrayList.add(co2);
        arrayList.add(co3);
        arrayList.add(co4);
        // la liste arrayList à 'nettoyer' est trié par date on fait en sorte d'éliminée les valeurs
        // inutile dans cette liste car déductible à partir des autres
        ArrayList<Consumption> result = new ArrayList<>();
        result.add(co1);
        result.add(co3);
        result.add(co4);
        // la liste result est le résultat attendu
        assertEquals(result,consumptionService.cleanList(arrayList));
    }
}
