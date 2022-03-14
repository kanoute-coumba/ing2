package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.*;
import episen.pds.citizens.backcitizens.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OverrunService {

    @Autowired
    private ConsumptionDayRepo consumptionRepo;
    @Autowired
    private AttributionRepo attributionRepo;
    @Autowired
    private PeakDayRepo peakdayRepo;
    @Autowired
    private PeakMonthRepo peakmonthRepo;
    @Autowired
    private PeakYearRepo peakyearRepo;

    public Iterable<ConsumptionDay> getConsumption() {
        return consumptionRepo.findConsoPerDay();
    }

    public Iterable<Attribution> getAttribution() {
        return attributionRepo.getAttribution();
    }
    public Iterable<Attribution> getAllAttribAfterMock() {
        return attributionRepo.findAll();
    }

    public Iterable<ConsumptionDay> getAllConsoAfterMock() {
        return consumptionRepo.findAll();
    }

    public Iterable<PeakDay> getPeakDay() {
        return peakdayRepo.findPeakDay();
    }

    public Iterable<PeakYear> getPeak() {
        return peakyearRepo.getPeak();
    }
    public Iterable<PeakMonth> getPeak20() {
        return peakmonthRepo.getPeak20();
    }

    public Iterable<PeakMonth> getPeak21() {
        return peakmonthRepo.getPeak21();
    }

    public Iterable<PeakMonth> getPeak22() {
        return peakmonthRepo.getPeak22();
    }

}
