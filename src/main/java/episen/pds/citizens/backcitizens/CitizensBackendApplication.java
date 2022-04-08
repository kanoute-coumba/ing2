package episen.pds.citizens.backcitizens;

import episen.pds.citizens.backcitizens.controller.OverrunController;
import episen.pds.citizens.backcitizens.service.ConfigLightAutoDWP;
import episen.pds.citizens.backcitizens.service.ConfigTempAutoDWP;
import org.springframework.beans.factory.annotation.Autowired;
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
	MenuController menuController;

	@Autowired
	OverrunController overrunController;

	@Autowired
	ConfigLightAutoDWP configLightAutoDWP;

	@Autowired
	ConfigTempAutoDWP configTempAutoDWP;


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
		Thread configLightAuto = new Thread(configLightAutoDWP);
		configLightAuto.start();
		logger.info("starting light config auto thread");

		Thread configTempAuto = new Thread(configTempAutoDWP);
		configTempAuto.start();
		logger.info("starting temp config auto thread");

	}



	public static void main(String[] args) {
		SpringApplication.run(CitizensBackendApplication.class, args);
	}


}
