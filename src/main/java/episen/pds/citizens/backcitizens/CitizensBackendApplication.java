package episen.pds.citizens.backcitizens;

import episen.pds.citizens.backcitizens.controller.EquipmentController;
import episen.pds.citizens.backcitizens.controller.OverrunController;
import org.springframework.beans.factory.annotation.Autowired;
import episen.pds.citizens.backcitizens.controller.TestController;
import episen.pds.citizens.backcitizens.controller.MenuController;
import episen.pds.citizens.backcitizens.controller.TestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Component
@SpringBootApplication
public class CitizensBackendApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(CitizensBackendApplication.class.getName());

	@Autowired
	TestController testController;
	@Autowired
	MenuController menuController;

	@Autowired
	OverrunController overrunController;

	@Autowired
	EquipmentController equipmentController;

	@Override
	public void run(String... args) throws Exception {
		logger.config("debut de la commande");
		logger.config(testController.getTest() + "");
		logger.config(overrunController.getAttribution() + "");
		logger.config(overrunController.getConsumption() + "");
		logger.config(String.valueOf(equipmentController.getEquipmentOrderByConsumptionByBuilding("1")));

	}


	public static void main(String[] args) {
		SpringApplication.run(CitizensBackendApplication.class, args);
	}

}
