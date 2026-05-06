package com.hibernate.Hibernate1;

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
        
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Enter the name, gender and salary");
    	Employee emp = new Employee(scan.next(), scan.next(), scan.nextInt());
    	
    	//Loading Configuration
    	Configuration conf = new Configuration().configure("hibernate.cfg.xml");
    	
    	//Build Session Factory
    	SessionFactory factory = conf.buildSessionFactory();
    	
    	//Open Session
    	Session session = factory.openSession();
    	
    	//Begin Session
    	Transaction transaction = session.beginTransaction();
    	
    	//Perform Operation
    	session.persist(emp);
    	
    	//Commit Session
    	transaction.commit();
    	
    	//Close Session and Factory
    	session.close();
    	factory.close();
    	scan.close();
    }
}
