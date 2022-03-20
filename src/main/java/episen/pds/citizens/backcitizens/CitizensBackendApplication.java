package episen.pds.citizens.backcitizens;

import episen.pds.citizens.backcitizens.controller.EquipmentController;
import episen.pds.citizens.backcitizens.controller.OverrunController;
import episen.pds.citizens.backcitizens.service.ConfigAutoDWP;
import org.springframework.beans.factory.annotation.Autowired;
import episen.pds.citizens.backcitizens.controller.TestController;
import episen.pds.citizens.backcitizens.controller.MenuController;
import episen.pds.citizens.backcitizens.controller.TestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.util.logging.Logger;

@Component
@SpringBootApplication
public class CitizensBackendApplication implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(CitizensBackendApplication.class.getName());


	@Autowired
	MenuController menuController;

	@Autowired
	OverrunController overrunController;

	@Autowired
	ConfigAutoDWP configAutoDWP;


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
		for (int i = 0; i < 10; i++) {
			Thread configAuto = new Thread(configAutoDWP);
			configAuto.start();
			logger.info("starting config auto thread");
			Thread.sleep(1000);
		}

	}



	public static void main(String[] args) {
		SpringApplication.run(CitizensBackendApplication.class, args);
	}


}
