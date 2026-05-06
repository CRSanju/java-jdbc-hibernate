package com.employee2.OneToOne;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        
    	Scanner scan = new  Scanner(System.in);
        System.out.println("Enter streetno, streetname, city, state, country and pincode");
        Address addrress = new Address(scan.nextInt(), scan.next(), scan.next(), scan.next(), scan.next(), scan.nextInt());
        
        System.out.println("Enter student name, marks and age");
        Student student = new Student(scan.next(), scan.nextInt(), scan.nextInt(), addrress);
        
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        session.persist(student);
        
        transaction.commit();
        
        session.close();
        sessionFactory.close();
        scan.close();
    }
}
