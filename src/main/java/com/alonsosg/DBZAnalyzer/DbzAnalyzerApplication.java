package com.alonsosg.DBZAnalyzer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alonsosg.DBZAnalyzer.principal.Principal;

@SpringBootApplication
public class DbzAnalyzerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DbzAnalyzerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.muestraMenu();
	}

}
