package com.employee2.OnetoMany;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        
    	Course c1 = new Course("JAVA");
    	Course c2 = new Course("PYTHON");
    	Course c3 = new Course("C#");
    	
    	Student student = new Student("Raj", "raj@kod.in", "9945454544465");
    	
    	c1.setStudent(student);
    	c2.setStudent(student);
    	c3.setStudent(student);
    	
    	ArrayList<Course> courses = new ArrayList<Course>();
    	
    	courses.add(c1);
    	courses.add(c2);
    	courses.add(c3);
    	
    	student.setRef(courses);
    	
    	 SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	 Session session = factory.openSession();
    	 Transaction transaction = session.beginTransaction();
    	 
    	 session.persist(student);
    	 transaction.commit();
    	 
    	 session.close();
    	 factory.close();
    }
}
