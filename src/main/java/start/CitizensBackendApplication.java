package start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class CitizensBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitizensBackendApplication.class, args);
	}
	
}
