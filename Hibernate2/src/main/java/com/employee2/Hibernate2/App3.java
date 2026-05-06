package com.employee2.Hibernate2;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Enter ID to remove the details");
		int id = sc.nextInt();
		Book ref = session.get(Book.class, id);

		//To remove files from the table
		if (ref != null) {
			session.remove(ref);
			System.out.println("Book deleted successfully");
		} else {
			System.out.println("Book not found");
		}
		transaction.commit();

		//close session and factory
		session.close();
		factory.close();
		sc.close();

	}

}
