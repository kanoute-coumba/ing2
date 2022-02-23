package episen.pds.citizens.backcitizens;

import episen.pds.citizens.backcitizens.controller.EquipmentController;
import org.springframework.beans.factory.annotation.Autowired;
import episen.pds.citizens.backcitizens.controller.TestController;
import episen.pds.citizens.backcitizens.controller.MenuController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


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
	EquipmentController equipmentController;

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}

	@Override
	public void run(String... args) throws Exception {
		logger.config("debut de la commande");
		logger.config(testController.getTest() + "");
		logger.config(String.valueOf(equipmentController.getEquipmentOrderByConsumptionByBuilding("1")));
	}


	public static void main(String[] args) {
		SpringApplication.run(CitizensBackendApplication.class, args);
	}

}
