package start;

import org.springframework.beans.factory.annotation.Autowired;
import start.controller.TestController;
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

	@Override
	public void run(String... args) throws Exception {
		logger.info("debut de la commande");
		testController.getTest();
	}


	public static void main(String[] args) {
		SpringApplication.run(CitizensBackendApplication.class, args);
	}

}
