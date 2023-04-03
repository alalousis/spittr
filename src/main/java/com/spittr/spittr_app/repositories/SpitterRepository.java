package com.spittr.spittr_app.repositories;

import com.spittr.spittr_app.models.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SpitterRepository {
    private SessionFactory sessionFactory;

    public SpitterRepository() {
        System.out.println("SpitterRepository.constructor");

        Configuration config=new Configuration();
        config.configure();
        sessionFactory = config.buildSessionFactory();
    }

    public void createSpitter(String username, String password, String firstName, String lastName, String email) {
        System.out.println("SpitterRepository.createSpitter");

        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Spitter spitter = new Spitter(null, username, password, firstName, lastName, email);
        session.save(spitter);

        transaction.commit();
        session.close();
    }

    public Spitter getSpitterByUsername(String username) {
        System.out.println("SpitterRepository.getSpitterByUsername");

        Session session = sessionFactory.openSession();

        Spitter spitter = session.bySimpleNaturalId(Spitter.class).load(username);

        session.close();
        return spitter;
    }

    public void updateSpitterEmailByUsername(String username, String email) {
        System.out.println("SpitterRepository.getSpitterByUsername");

        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Spitter spitter = session.bySimpleNaturalId(Spitter.class).load(username);
        spitter.setEmail(email);
        session.save(spitter);

        transaction.commit();
        session.close();
    }

    public void deleteSpitterByUsername(String username) {
        System.out.println("SpitterRepository.deleteSpitterByUsername");

        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Spitter spitter = session.bySimpleNaturalId(Spitter.class).load(username);
        session.delete(spitter);

        transaction.commit();
        session.close();
    }

}
