package com.vf.nach.msprueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.vf.nach.msprueba.*")
public class MspruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MspruebaApplication.class, args);
	}

}
