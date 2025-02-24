package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.function.client.WebClient;

@ComponentScan(basePackages = {"controller"})
@SpringBootApplication
public class MicroservicioGetToken {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioGetToken.class, args);
	}
	
	@Bean
	public WebClient getClient() {
		return WebClient.create();
	}

}
