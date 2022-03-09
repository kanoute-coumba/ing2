package episen.pds.citizens.backcitizens.service;

import java.util.ArrayList;
import java.util.List;

public class FunctionForAlgoMix {

    // function that returns the economic cost for each energy ([solar,wind turbine, hydraulic]) according to the desired production

    public List<Double> economicCost(float consumption){
        // production cost
        double productionCostSolarWs = 0.0394;
        double productionCostWindTurbineWs = 0.0556;
        double productionCostHydraulicWs = 0.005;

        // unit cost central
        double unitCostSolar = 1700;
        double unitCostWindTurbine = 1400;
        double unitCostHydraulic = 5400;

        // capacity production
        float capacityOneSolarCentral = 1000;
        float capacityOneWindTurbineCentral = 1000;
        float capacityOneHydraulicCentral = 1500;

        // year of installation
        float installationSolarYear = 5;
        float installationWindTurbineYear = 5;
        float installationHydraulicYear = 10;

        // amortization
        float amortizationSolarYear = 10;
        float amortizationWindTurbineYear = 15;
        float amortizationHydraulicYear = 25;

        //result
        double economicCostSolar = productionCostSolarWs*consumption;
        double economicCostWindTurbine = productionCostWindTurbineWs*consumption;
        double economicCostHydraulic = productionCostHydraulicWs*consumption;
        List<Double> res = new ArrayList<>();

        if(installationSolarYear < amortizationSolarYear){
            economicCostSolar += (Math.ceil(consumption/capacityOneSolarCentral))*unitCostSolar/amortizationSolarYear;
        }
        if(installationWindTurbineYear < amortizationWindTurbineYear){
            economicCostWindTurbine += (Math.ceil(consumption/capacityOneWindTurbineCentral))*unitCostWindTurbine/amortizationWindTurbineYear;
        }
        if(installationHydraulicYear < amortizationHydraulicYear){
            economicCostHydraulic += (Math.ceil(consumption/capacityOneHydraulicCentral))*unitCostHydraulic/amortizationHydraulicYear;
        }
        res.add(economicCostSolar);
        res.add(economicCostWindTurbine);
        res.add(economicCostHydraulic);

        return res;
    }

    public List<Double> environmentalCost(float consumption){
        //result
        List<Double> res = new ArrayList<>();

        return res;
    }

}
