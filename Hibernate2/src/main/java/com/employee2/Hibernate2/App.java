package com.employee2.Hibernate2;

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
		System.out.println("Enter bookname, price, author and publisher");
		Book book = new Book(scan.next(), scan.nextInt(), scan.next(), scan.next());

		//Loading Configuration
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		//Build Session Factory
		SessionFactory factory = con.buildSessionFactory();
		//Open Session
		Session session = factory.openSession();
    	//Begin Session
		Transaction transaction = session.beginTransaction();
		//Perform Operation
		session.persist(book);
    	//Commit Session
		transaction.commit();
	   	//Close Session and Factory
		session.close();
		factory.close();
		scan.close();

	}
}
