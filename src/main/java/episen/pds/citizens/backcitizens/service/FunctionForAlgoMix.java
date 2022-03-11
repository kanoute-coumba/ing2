package episen.pds.citizens.backcitizens.service;

import java.util.ArrayList;
import java.util.List;

public class FunctionForAlgoMix {
    private float installationSolarYear = 5;
    private float installationWindTurbineYear = 5;
    private float installationHydraulicYear = 10;

    public FunctionForAlgoMix(){}

    public FunctionForAlgoMix(float installationSolarYear, float installationWindTurbineYear, float installationHydraulicYear){
        this.installationSolarYear = installationSolarYear;
        this.installationWindTurbineYear = installationWindTurbineYear;
        this.installationHydraulicYear = installationHydraulicYear;
    }

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

    // function that returns the environmental cost for each energy ([solar,wind turbine, hydraulic]) according to the desired production

    public List<Double> environmentalCost(float consumption){
        // Life cycle analysis
        double environmenatalCostSolarWh = 55;
        double environmenatalCostWindTurbineWh = 12.7;
        double environmenatalCostHydraulicWh = 6;

        //result
        List<Double> res = new ArrayList<>();

        res.add(environmenatalCostSolarWh*consumption/1000);
        res.add(environmenatalCostWindTurbineWh*consumption/1000);
        res.add(environmenatalCostHydraulicWh*consumption/1000);

        return res;
    }

}
