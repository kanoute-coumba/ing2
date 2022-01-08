package episen.pds.citizens.backcitizens.service;

import episen.pds.citizens.backcitizens.controller.EquipmentController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class ThreadLight implements Runnable {


    private EquipmentService equipmentService;
    private String id;
    private static final Logger logger = Logger.getLogger(ThreadLight.class.getName());

    public ThreadLight(EquipmentService equipmentService, String id) {
        this.equipmentService = equipmentService;
        this.id = id;
    }

    @Override
    public void run() {
        Integer id_equipment = Integer.valueOf(id);
        int hours = 0;
        while (true) {

            if ((hours >= 0 && hours < 7) || (hours >= 8 && hours < 18)) {
                System.out.println(" entre 0h et 7h");

                if (hours == 0 || hours == 8) {
                    equipmentService.UpdateValueEquipment(0, id_equipment);
                    equipmentService.UpdateStatutMode("OFF", "Automatique", id_equipment);
                }
            } else if (hours >= 7 && hours < 8) {
                System.out.println(" entre 7h et 8h");
                equipmentService.UpdateValueEquipment(5, 36);
                equipmentService.UpdateStatutMode("ON", "Automatique", id_equipment);
            } else if (hours >= 18 && hours < 0) {
                System.out.println(" entre 18h et 0h");
                if (hours == 18) {
                    equipmentService.UpdateValueEquipment(10, id_equipment);
                    equipmentService.UpdateStatutMode("ON", "Automatique", id_equipment);
                }
            }
            hours++;
            if (hours == 25) {
                hours = 0;
            }
            System.out.println("Automatic update" + hours);
            try {
                sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
