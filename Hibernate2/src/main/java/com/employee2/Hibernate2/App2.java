package com.employee2.Hibernate2;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App2 {
	public static void main(String args[]) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter ID to fetch book details: ");
		
		//to fetch the details as per the id
		Book ref = session.get(Book.class, scan.nextInt());
//		System.out.println(ref);
		System.out.println(ref.getId() + " " + ref.getBookname() + " " + ref.getPrice()+ " "+ ref.getAuthor() + " "+ ref.getPublisher() );

		transaction.commit();
		
		session.close();
		factory.close();
		scan.close();
	}
}
