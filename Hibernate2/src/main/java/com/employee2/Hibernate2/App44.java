package com.employee2.Hibernate2;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App44 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		// TO UPDATE DETAILS ONE BY ONE
		System.out.println("Enter Book ID to update details");
		int id = scan.nextInt();
		scan.nextLine();

		Book ref = session.get(Book.class, id);

		if (ref != null) {

			while (true) {
				System.out.println("Press 1 to update name");
				System.out.println("Press 2 to update price");
				System.out.println("Press 3 to update author");
				System.out.println("Press 4 to update publisher");
				System.out.println("Press 5 to update and exit");

				int choice = scan.nextInt();
				if (choice == 5) {
					break;
				}
				switch (choice) {
				case 1: {
					System.out.println("Enter new Book name");
					String name = scan.next();
					ref.setBookname(name);
					break;
				}

				case 2: {
					System.out.println("Enter new price");
					int price = scan.nextInt();
					ref.setPrice(price);
					break;
				}

				case 3: {
					System.out.println("Enter new author");
					String author = scan.next();
					ref.setAuthor(author);
					break;
				}

				case 4: {
					System.out.println("Enter the new publisher");
					String publisher = scan.next();
					ref.setPublisher(publisher);
					break;
				}

				default: {
					System.out.println("Invalid option. Try again.....");
				}
				}
			}
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
