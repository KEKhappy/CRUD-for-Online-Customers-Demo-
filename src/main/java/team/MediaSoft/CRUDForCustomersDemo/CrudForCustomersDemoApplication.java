package team.MediaSoft.CRUDForCustomersDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
@Profile("production")
@SpringBootApplication
public class CrudForCustomersDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrudForCustomersDemoApplication.class, args);
	}
}
