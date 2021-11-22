package episen.pds.citizens.backcitizens;

import episen.pds.citizens.backcitizens.controller.ConsumptionController;
import org.springframework.beans.factory.annotation.Autowired;
import episen.pds.citizens.backcitizens.controller.TestController;
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
	ConsumptionController consumptionController;

	@Override
	public void run(String... args) throws Exception {
		logger.config("debut de la commande");
		logger.config(consumptionController.getConsumption() + "");
	}

	public static void main(String[] args) {
		SpringApplication.run(CitizensBackendApplication.class, args);
	}

}
