package io.github.rodrik.demo.football;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import io.github.rodrik.demo.football.client.SeasonService;
import io.github.rodrik.demo.football.client.retrofit.RetrofitFactory;

@SpringBootApplication
public class DemoFootbalApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoFootbalApplication.class, args);
	}
	
	@Bean
	public SeasonService seasonService() {
		return RetrofitFactory.getSeasonService();
	}

	@Override
	public void run(String... args) throws Exception {
		seasonService().getSeasons().execute();
	}
}
