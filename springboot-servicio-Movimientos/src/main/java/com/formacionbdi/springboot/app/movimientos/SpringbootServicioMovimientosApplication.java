package com.formacionbdi.springboot.app.movimientos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringbootServicioMovimientosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioMovimientosApplication.class, args);
	}

}
