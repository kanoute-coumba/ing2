package episen.pds.citizens.backcitizens;

import episen.pds.citizens.backcitizens.controller.OverrunController;
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
	OverrunController overrunController;

	@Override
	public void run(String... args) throws Exception {
		logger.config("debut de la commande");
		logger.config(overrunController.getAttribution() + "");
		//logger.config(overrunController.getConsumption() + "");
	}

	public static void main(String[] args) {
		SpringApplication.run(CitizensBackendApplication.class, args);
	}

}
