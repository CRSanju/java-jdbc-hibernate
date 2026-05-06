package com.employee2.Hibernate2;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App4 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		
		//TO UPDATE DETAILS
		System.out.println("Enter Book ID to update all the details");
		int id = scan.nextInt();
		scan.nextLine();
		Book ref = session.get(Book.class, id);
		if (ref != null) {
			System.out.println("Enter new BookName");
			ref.setBookname(scan.nextLine());
			
			System.out.println("Enter new Price");
			ref.setPrice(scan.nextInt());
			scan.nextLine();
			
			System.out.println("Enter the author name");
			ref.setAuthor(scan.nextLine());

			System.out.println("Enter the publisher name");
			ref.setPublisher(scan.nextLine());

			System.out.println("Book updated successfully");
		} else {
			System.out.println("Book not found of ID: " + id);
		}

		transaction.commit();

		session.close();
		factory.close();
		scan.close();
	}

}
