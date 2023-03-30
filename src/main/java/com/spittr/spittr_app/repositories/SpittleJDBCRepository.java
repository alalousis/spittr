package com.spittr.spittr_app.repositories;

import com.spittr.spittr_app.configuration.ConnectionFactory;
import com.spittr.spittr_app.models.Spittle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpittleJDBCRepository {
    private ConnectionFactory connectionFactory;
    private Connection connection;

    public SpittleJDBCRepository() {
         /* Add system.out.prinln indicative message */
        connectionFactory = new ConnectionFactory();
        connection = connectionFactory.getConnection();
    }

    public void createSpittle(Long id, String message, String time, Double longitude, Double latitude) {
        /* Add system.out.prinln indicative message */
        SpittleJDBCRepository spittleDAOService = new SpittleJDBCRepository();
        Spittle spittle = spittleDAOService.getSpittleById(id);

        if (spittle == null) {
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO spittle (id, message, time, longitude, latitude) VALUES (?, ?, ?, ?, ?);");
                ps.setLong(1, id);
                ps.setString(2, message);
                ps.setString(3, time);
                ps.setDouble(4, longitude);
                ps.setDouble(5, latitude);
                ps.executeUpdate();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else{
            System.err.println("\nSpittle with id:" + id + " already exists");
        }
    }

    public Spittle getSpittleById(Long id) {
         /* Add system.out.prinln indicative message */
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM spittle WHERE id=?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                Spittle spittle = new Spittle();

                spittle.setId( rs.getLong("id") );
                spittle.setMessage( rs.getString("message") );
                spittle.setTime( rs.getString("time") );
                spittle.setLongitude( rs.getDouble("longitude") );
                spittle.setLatitude( rs.getDouble("latitude") );

                return spittle;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }


    public void updateSpittleMessageById(Long id, String message) {
         /* Add system.out.prinln indicative message */
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE spittle SET message=? where id = ?;");
            ps.setString(1, message);
            ps.setLong(2, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void deleteSpittleById(Long id) {
         /* Add system.out.prinln indicative message */
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE from spittle where id = ?;");
            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}

