package com.rancho_smart.ms_procedimientos_medicos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsProcedimientosMedicosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProcedimientosMedicosApplication.class, args);
	}

}
