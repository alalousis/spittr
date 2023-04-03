package com.spittr.spittr_app.services;

import com.spittr.spittr_app.models.Spittle;
import com.spittr.spittr_app.repositories.SpittleRepository;
import com.spittr.spittr_app.repositories.SpittleJDBCRepository;

public class SpittleService {
    private SpittleJDBCRepository spittleJDBCRepository;
    private SpittleRepository spittleRepository;

    public SpittleService() {
        this.spittleJDBCRepository = new SpittleJDBCRepository();
        this.spittleRepository = new SpittleRepository();
    }

    public void createSpittle(String message, String time, Double longitude, Double latitude){
        System.out.println("\nCreate new spittle ...");
        System.out.println("SpittleService.createSpittle");

        // ------ Plain JAVA -------------
        //return new Spittle(id, message, time, longitude, latitude);

        // ------ JDBC Repository  ---------------
        //this.spittleJDBCRepository.createSpittle(message, time, longitude, latitude);

        // -------- Hibernate Repository ---------
        this.spittleRepository.createSpittle(message, time, longitude, latitude);
    }
    public Spittle readSpittleById(Long id){
        System.out.println("\nRead spittle:");

        // ------ Plain JAVA -------------
        //System.out.println(spittle.read());

        // ------ JDBC Repository  ---------------
        //return this.spittleJDBCRepository.getSpittleById(id);

        // -------- Hibernate Repository ---------
        return this.spittleRepository.getSpittleById(id);

    }
    public void updateSpittleMessage(Long id, String message){
        System.out.println("\nUpdate spittle ...:");

        // ------ Plain JAVA -------------
        //spittle.update(message);

        // ------ JDBC Repository  ---------------
        //spittleJDBCRepository.updateSpittleMessageById(id, message);

        // -------- Hibernate Repository ---------
        spittleRepository.updateSpittleMessageById(id, message);
    }

    public void deleteSpittle(Long id){
        System.out.println("\nDelete spittle ...:");

        // ------ Plain JAVA -------------
        //spittle = null;

        // ------ JDBC Repository  ---------------
        //spittleJDBCRepository.deleteSpittleById(id);

        // -------- Hibernate Repository ---------
        spittleRepository.deleteSpittleById(id);
    }
}
