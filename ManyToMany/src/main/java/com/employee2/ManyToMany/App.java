package com.employee2.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		Club c1 = new Club("Culture");
		Club c2 = new Club("Cricket");
		Club c3 = new Club("Radio");

		Student s1 = new Student("Anil", "Ani@kod.in");
		Student s2 = new Student("Balu", "Balu@kod.in");
		Student s3 = new Student("Ravi", "Ra@kod.in");

		List<Club> cl1 = new ArrayList<>();
		cl1.add(c1);
		cl1.add(c2);
		cl1.add(c3);

		List<Club> cl2 = new ArrayList<>();
		cl2.add(c1);
		cl2.add(c2);

		List<Club> cl3 = new ArrayList<>();
		cl3.add(c2);
		cl3.add(c3);

		s1.setClubs(cl1);
		s2.setClubs(cl2);
		s3.setClubs(cl3);

		List<Student> sl1 = new ArrayList<>();
		sl1.add(s1);
		sl1.add(s2);

		List<Student> sl2 = new ArrayList<>();
		sl2.add(s1);
		sl2.add(s2);
		sl2.add(s3);

		List<Student> sl3 = new ArrayList<>();
		sl3.add(s1);
		sl3.add(s3);

		c1.setStudents(sl1);
		c2.setStudents(sl2);
		c3.setStudents(sl3);

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		session.persist(s1);
		session.persist(s2);
		session.persist(s3);

		transaction.commit();

		session.close();
		factory.close();
	}
}
