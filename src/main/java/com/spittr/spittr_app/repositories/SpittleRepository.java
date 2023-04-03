package com.spittr.spittr_app.repositories;

import com.spittr.spittr_app.models.Spittle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SpittleRepository {
    private SessionFactory sessionFactory;

    public SpittleRepository() {
        System.out.println("SpittleRepository.constructor");
        Configuration config=new Configuration();
        config.configure();
        sessionFactory = config.buildSessionFactory();
    }

    public void createSpittle(String message, String time, Double longitude, Double latitude) {
        System.out.println("SpittleRepository.createSpittle");

        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Spittle spittle = new Spittle(null, message, time, longitude, latitude);
        session.save(spittle);

        transaction.commit();
        session.close();

    }

    public Spittle getSpittleById(Long id) {
        System.out.println("SpittleRepository.getSpittleByUsername");

        Session session = sessionFactory.openSession();

        Spittle spittle = session.get(Spittle.class, id);

        session.close();
        return spittle;
    }

    public void updateSpittleMessageById(Long id, String message) {
        System.out.println("SpittleRepository.getSpittleByUsername");

        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Spittle spittle = session.get(Spittle.class, id);
        spittle.setMessage(message);
        session.save(spittle);

        transaction.commit();
        session.close();
    }

    public void deleteSpittleById(Long id) {
        System.out.println("SpittleRepository.deleteSpittleByUsername");

        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Spittle spittle = session.get(Spittle.class, id);
        session.delete(spittle);

        transaction.commit();
        session.close();
    }

}
