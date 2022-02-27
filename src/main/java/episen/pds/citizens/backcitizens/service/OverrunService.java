package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.model.Attribution;
import episen.pds.citizens.backcitizens.model.ConsumptionDay;
import episen.pds.citizens.backcitizens.model.PeakDay;
import episen.pds.citizens.backcitizens.model.Test;
import episen.pds.citizens.backcitizens.repository.ConsumptionDayRepo;
import episen.pds.citizens.backcitizens.repository.AttributionRepo;
import episen.pds.citizens.backcitizens.repository.PeakDayRepo;
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
    //public PeakDay getPeakDay(PeakDay peakday) {
        //return peakdayRepo.save(peakday);
    //}


    public Iterable<PeakDay> getPeak() {
        return peakdayRepo.getPeak();
    }

}
