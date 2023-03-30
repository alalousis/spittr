package com.spittr.spittr_app;

import com.spittr.spittr_app.models.Spitter;
import com.spittr.spittr_app.models.Spittle;
import com.spittr.spittr_app.services.SpitterService;
import com.spittr.spittr_app.services.SpittleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpittrAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpittrAppApplication.class, args);

		// ----------- Spitter -----------
		SpitterService spitterService = new SpitterService();
//		spitterService.createSpitter(1000L, "leonelMessi","1030", "leonel", "messi", "leonel.messi@gmail.com");
		spitterService.createSpitter(2000L, "leondardodicaprio", "4567", "leonardo", "dicaprio", "dicaprio@gmail.com");


		Spitter spitterMessi = spitterService.readSpitterByUsername("leonelMessi");
		System.out.println(spitterMessi.toString());

		spitterService.updateSpitterEmailByUsername("leonelMessi", "leo@gmail.com");
		System.out.println(spitterService.readSpitterByUsername("leonelMessi"));

		// ----------- Spittle -----------
		SpittleService spittleService = new SpittleService();
		spittleService.createSpittle(1024, "Good Morning!","10:30", 123456.789, 987654.321);

		Spittle hello = spittleService.readSpittleById(1024L);
		System.out.println(hello.toString());

		spittleService.updateSpittleMessage(1024L, "Good Night!");
		System.out.println(spittleService.readSpittleById(1024L));



	}

}
