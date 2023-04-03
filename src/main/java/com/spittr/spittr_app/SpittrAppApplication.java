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

		// Create
		spitterService.createSpitter("michaeljackson", "1960", "michael", "jackson", "michaeljackson@gmail.com");

		//Read
		Spitter spitterDicaprio = spitterService.readSpitterByUsername("leondardodicaprio");
		System.out.println(spitterDicaprio.toString());

		//Update
		spitterService.updateSpitterEmailByUsername("leondardodicaprio", "leo@gmail.com");
		System.out.println(spitterService.readSpitterByUsername("leondardodicaprio"));

		//Delete
		//spitterService.deleteSpitterByUsername("leondardodicaprio2");

		// ----------- Spittle -----------
		SpittleService spittleService = new SpittleService();

		//Create
		spittleService.createSpittle("Good Morning!","10:30", 123456.789, 987654.321);

		//Read
		Spittle hello = spittleService.readSpittleById(1028L);
		System.out.println(hello.toString());

		//Update
		spittleService.updateSpittleMessage(1026L, "Good Night!");
		System.out.println(spittleService.readSpittleById(1026L));

		//Delete
		//spittleService.deleteSpittle(1024L);

		System.out.println("END");
		return;
	}

}
