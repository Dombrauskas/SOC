package br.com.soc.exame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ExameApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ExameApplication.class, args);
	}
}
