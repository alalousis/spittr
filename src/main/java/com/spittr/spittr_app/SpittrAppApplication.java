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
		spitterService.createSpitter("michaeljackson", "1960", "michael", "jackson", "michaeljackson@gmail.com");


		Spitter spitterDicaprio = spitterService.readSpitterByUsername("leondardodicaprio");
		System.out.println(spitterDicaprio.toString());

		spitterService.updateSpitterEmailByUsername("leondardodicaprio", "leo@gmail.com");
		System.out.println(spitterService.readSpitterByUsername("leondardodicaprio"));

		//spitterService.deleteSpitterByUsername("leondardodicaprio2");

		// ----------- Spittle -----------
		SpittleService spittleService = new SpittleService();
		spittleService.createSpittle("Good Morning!","10:30", 123456.789, 987654.321);

		Spittle hello = spittleService.readSpittleById(1024L);
		System.out.println(hello.toString());

//		spittleService.updateSpittleMessage(1024L, "Good Night!");
//		System.out.println(spittleService.readSpittleById(1024L));



	}

}
