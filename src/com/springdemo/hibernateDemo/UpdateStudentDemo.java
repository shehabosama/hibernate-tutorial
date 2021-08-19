package com.springdemo.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdemo.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			
			
			// find out hte student's id : primary key
			System.out.println("Saved student . Genereted id : "+ studentId);
			
			// now get a new session and start transaction 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id primary key
			System.out.println("\n Getting student with id : "+ studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Updating student...");
			myStudent.setFirstName("malek");
			//commit the transaction
			session.getTransaction().commit();
			
			// MY NEW CODE
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			//update email for all students
			System.out.println("Update email for all students");
			session.createQuery("update Student set email='foo@shehab.com'").executeUpdate();
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			}finally {
				factory.close();
			
			}
		}

		
	
}
