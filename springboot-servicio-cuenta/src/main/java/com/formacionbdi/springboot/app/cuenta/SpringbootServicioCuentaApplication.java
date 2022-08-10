package com.formacionbdi.springboot.app.cuenta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringbootServicioCuentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioCuentaApplication.class, args);
	}

}
