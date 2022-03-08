package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.*;
import episen.pds.citizens.backcitizens.repository.ConsumptionDayRepo;
import episen.pds.citizens.backcitizens.repository.AttributionRepo;
import episen.pds.citizens.backcitizens.repository.PeakDayRepo;
import episen.pds.citizens.backcitizens.repository.PeakYearRepo;
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

    public Iterable<PeakYear> getPeak20() {
        return peakyearRepo.getPeak20();
    }

    public Iterable<PeakYear> getPeak21() {
        return peakyearRepo.getPeak21();
    }

    public Iterable<PeakYear> getPeak22() {
        return peakyearRepo.getPeak22();
    }

}
