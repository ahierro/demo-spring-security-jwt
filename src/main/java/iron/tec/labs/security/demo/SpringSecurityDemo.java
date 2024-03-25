package iron.tec.labs.security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import java.time.Clock;

@SpringBootApplication
@EnableMethodSecurity
public class SpringSecurityDemo {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemo.class, args);
	}


	@Bean
	public Clock clock(){
		return Clock.systemDefaultZone();
	}
}
