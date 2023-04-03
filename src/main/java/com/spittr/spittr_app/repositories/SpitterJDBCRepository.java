package com.spittr.spittr_app.repositories;

import com.spittr.spittr_app.configuration.ConnectionFactory;
import com.spittr.spittr_app.models.Spitter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpitterJDBCRepository {
    private ConnectionFactory connectionFactory;
    private Connection connection;

    public SpitterJDBCRepository() {
        System.out.println("SpitterJDBCRepository.constructor");
        connectionFactory = new ConnectionFactory();
        connection = connectionFactory.getConnection();
    }

    public void createSpitter(String username, String password, String firstName, String lastName, String email) {
        System.out.println("SpitterJDBCRepository.createSpitter");

        Spitter spitter = this.getSpitterByUsername(username);
        if (spitter == null) {
            try {
//                Long id = this.getMaxId() + 1;
                PreparedStatement ps = connection.prepareStatement("INSERT INTO spitter (username, password, firstName, lastName, email) VALUES (?, ?, ?, ?, ?);");
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, firstName);
                ps.setString(4, lastName);
                ps.setString(5, email);
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.err.println("Test");
                //ex.printStackTrace();
            }
        }
        else{
            System.err.println("Spitter with username:" + username + " already exists");
        }
    }

    public Spitter getSpitterByUsername(String username) {
        System.out.println("SpitterJDBCRepository.getSpitterByUsername");
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM spitter WHERE username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                Spitter spitter = new Spitter();
                spitter.setId( rs.getLong("id") );
                spitter.setUsername( rs.getString("username") );
                spitter.setPassword( rs.getString("password") );
                spitter.setFirstName( rs.getString("firstName") );
                spitter.setLastName( rs.getString("lastName") );
                spitter.setEmail( rs.getString("email") );
                return spitter;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public void updateSpitterEmailByUsername(String username, String email) {
        System.out.println("SpitterJDBCRepository.updateSpitterEmailByUsername");
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE spitter SET email=? where username = ?;");
            ps.setString(1, email);
            ps.setString(2, username);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteSpitterByUsername(String username) {
        System.out.println("SpitterJDBCRepository.deleteSpitterByUsername");
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE from spitter where username = ?;");
            ps.setString(1, username);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
