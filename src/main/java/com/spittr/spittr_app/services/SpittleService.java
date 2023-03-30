package com.spittr.spittr_app.services;

import com.spittr.spittr_app.models.Spittle;
import com.spittr.spittr_app.repositories.SpittleJDBCRepository;

public class SpittleService {
    private SpittleJDBCRepository spittleJDBCRepository;

    public SpittleService() {
        this.spittleJDBCRepository = new SpittleJDBCRepository();
    }

    public void createSpittle(long id, String message, String time, Double longitude, Double latitude){
        System.out.println("\nCreate new spittle ...");

        // ------ Plain JAVA -------------
        //return new Spittle(id, message, time, longitude, latitude);

        // ------ JDBC Repository  ---------------
        this.spittleJDBCRepository.createSpittle(id, message, time, longitude, latitude);
    }
    public Spittle readSpittleById(Long id){
        System.out.println("\nRead spittle:");

        // ------ Plain JAVA -------------
        //System.out.println(spittle.read());

        // ------ JDBC Repository  ---------------
        return this.spittleJDBCRepository.getSpittleById(id);

    }
    public void updateSpittleMessage(Long id, String message){
        System.out.println("\nUpdate spittle ...:");

        // ------ Plain JAVA -------------
        //spittle.update(message);

        // ------ JDBC Repository  ---------------
        spittleJDBCRepository.updateSpittleMessageById(id, message);
    }

    public void deleteSpittle(Long id){
        System.out.println("\nDelete spittle ...:");

        // ------ Plain JAVA -------------
        //spittle = null;

        // ------ JDBC Repository  ---------------
        spittleJDBCRepository.deleteSpittleById(id);
    }
}
