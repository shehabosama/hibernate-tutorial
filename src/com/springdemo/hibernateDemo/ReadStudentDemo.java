package com.springdemo.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdemo.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
		    // create a student object 
			System.out.println("Creating new student object ...");
			Student tempStudent = new Student("Daffy" , "duck" , "Daffyduck@gmail.com");
			// start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the Student....");
			System.out.println(tempStudent);
			session.save(tempStudent);
			// commit transaction
			session.getTransaction().commit();
			
			// MY NEW CODE
			// find out hte student's id : primary key
			System.out.println("Saved student . Genereted id : "+ tempStudent.getId());
			
			// now get a new session and start transaction 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id primary key
			System.out.println("\n Getting student with id : "+ tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println(myStudent.getId()+" "+myStudent.getFirstName()+" "+myStudent.getLastName()+" "+myStudent.getEmail());
			//commit hte transaction
			session.getTransaction();
			
			
			System.out.println("Done!");
			}finally {
				factory.close();
			
			}
		}

		
	
}
