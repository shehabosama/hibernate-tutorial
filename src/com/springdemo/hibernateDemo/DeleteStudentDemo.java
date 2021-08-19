package com.springdemo.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdemo.hibernate.entity.Student;

public class DeleteStudentDemo {

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
			System.out.println(" the id is : "+ studentId);
			
			// now get a new session and start transaction 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id primary key
			//System.out.println("\n Getting student with id : "+ studentId);
			//Student myStudent = session.get(Student.class, studentId);
			
			//delete the student
		//	System.out.println("Deleting student : "+ myStudent);
		//	session.delete(myStudent);
			// commit transaction
		//	session.getTransaction().commit();
			
			// MY NEW CODE
			
		
			//session.beginTransaction();
			//delete student
			System.out.println("Delete Student wiht id = 2");
			session.createQuery("Delete from Student where id=2").executeUpdate();
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			}finally {
				factory.close();
			
			}
		}

		
	
}
