package episen.pds.citizens.backcitizens;

import episen.pds.citizens.backcitizens.model.Conditions;
import episen.pds.citizens.backcitizens.model.Measure;
import episen.pds.citizens.backcitizens.repository.*;
import episen.pds.citizens.backcitizens.service.UseMonitorService;
import junit.framework.TestCase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

@SpringBootTest
public class ConfigTempAutoDWPTest extends TestCase {

    @Autowired
    UseMonitorService useMonitorService;
    @Autowired
    MeasureRepo measureRepo;

    @Autowired
    ConditionsRepo conditionsRepo;
    @Autowired
    RoomRepo roomRepo;
    @Autowired
    EquipmentAndDataRepo equipmentAndDataRepo;
    @Autowired
    SensorRepo sensorRepo;

    @Test
    public void configAuto() {
        // changer la température de la salle 52740 : 15
        Measure measures = new Measure(); measures.setTimestamp(LocalDateTime.of(2023,5,20, 0,0)); measures.setValue(15);
        measures.setId_sensor(sensorRepo.getTempSensorInRoom(52740).getId_sensor());
        measureRepo.save(measures);
        // Changer la température optimale de la salle 52740 : 24
        Conditions c = new Conditions(); c.setId_room(52740);c.setBegin_time(LocalDateTime.of(2023,5,20, 0,0));
        c.getEnd_time(LocalDateTime.of(2023,6,20, 0,0)); c.setTemperature(24);c.setLuminosity(500);
        conditionsRepo.save(c);
        // Recupérer la température de la salle 52740
        float temp = measureRepo.getTempStatInRoom(52740).getValue();
        // Récupérer la température optimale de la salle 52740
        float cond = conditionsRepo.findLastConditionsByRoom(52740).getTemperature();
        // S'assurer que difTemp == -9
        assert (temp - cond == -9);
        verify(this, atLeastOnce()).configTempAuto();

        // changer la température de la salle 52740 : 22
        measures = new Measure(); measures.setTimestamp(LocalDateTime.of(2023,6,20, 0,0)); measures.setValue(22);
        measures.setId_sensor(sensorRepo.getTempSensorInRoom(52740).getId_sensor());
        measureRepo.save(measures);
        // Changer la température optimale de la salle 52740 : 20
        c = new Conditions(); c.setId_room(52740);c.setBegin_time(LocalDateTime.of(2023,6,20, 0,0));
        c.getEnd_time(LocalDateTime.of(2023,7,20, 0,0)); c.setTemperature(20);c.setLuminosity(500);
        conditionsRepo.save(c);
        // Recupérer la température de la salle 52740
        temp = measureRepo.getTempStatInRoom(52740).getValue();
        // Récupérer la température optimale de la salle 52740
        cond = conditionsRepo.findLastConditionsByRoom(52740).getTemperature();
        // S'assurer que difTemp == 2
        assert (temp - cond == -9);
        verify(this, never()).configTempAuto();
    }



    @Test
    public void configTempAuto() {
        // Récupérer l'état des équipements de température de la salle 52740
        // Mettre difTemp à -100
        // Voir les équipements de température de la salle 52740 changer

        // Mettre difTemp à 100
        // Voir les équipements de température de la salle 52740 changer
    }
}
