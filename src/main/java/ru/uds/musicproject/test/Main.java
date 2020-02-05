package ru.uds.musicproject.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Create typesafe ServiceRegistry object
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("database/hibernate.cfg.xml").build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        List<Person> list = session.createQuery("FROM Person").list();
        for(Person person : list) {
            System.out.println(person.toString());
        }
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }
}