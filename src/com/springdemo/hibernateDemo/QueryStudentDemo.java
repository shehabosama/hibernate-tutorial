package com.springdemo.hibernateDemo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdemo.hibernate.entity.Student;



public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			// start transaction
			session.beginTransaction();
			//query student
			List<Student> theStudent = session.createQuery("from Student").getResultList();
			//display the student
			displayStudents(theStudent);
			// query students: lastName="osama"
			
			System.out.println("\n\n Student who have last name duck");
			theStudent = session.createQuery("from Student s where s.lastName='duck'").getResultList();
			
			displayStudents(theStudent);
			//query students : lastName 'osama' or first name ='shehab'
			System.out.println("\n\n Student who have last name osama or first name is shehab");
			theStudent = session.createQuery("from Student s where "
					+ " s.lastName='osama' AND s.firstName='shehab'").getResultList();
			displayStudents(theStudent);
			
			//	query students where email Like 'shehabosama'
			System.out.println("\n\n Student who have email name shehab");
			theStudent = session.createQuery("from Student s where s.email LIKE '%shehab%'").getResultList();
			displayStudents(theStudent);
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			}finally {
				factory.close();
			
			}
		}

	private static void displayStudents(List<Student> theStudent) {
		for(Student student : theStudent) {
			System.out.println(student);
		}
	}

		
	
}
