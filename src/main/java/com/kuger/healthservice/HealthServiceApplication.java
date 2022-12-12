package com.kuger.healthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = { "classpath:application.properties" })
public class HealthServiceApplication {
		public static void main(String[] args) {
			SpringApplication.run(HealthServiceApplication.class, args);
		}
}
