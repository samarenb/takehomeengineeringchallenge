package com.msft.foodtruck.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * This is the entry point of the application, Spring boot loads the context and initializes all
 * the beans and performs various dependency injections.
 * @author bajsamar
 *
 */
@SpringBootApplication(scanBasePackages = { "com.msft"})
public class RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

}
