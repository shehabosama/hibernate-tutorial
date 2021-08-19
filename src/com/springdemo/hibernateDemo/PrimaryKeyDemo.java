package com.springdemo.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdemo.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
				//create a session
				Session session = factory.getCurrentSession();
				
				try {
					
				    // create 3 student object 
					System.out.println("Creating 3 student object ...");
					Student tempStudent1 = new Student("shehab" , "osama" , "shehabosama@gmail.com");
					Student tempStudent2 = new Student("mayar" , "osama" , "mayar@gmail.com");
					Student tempStudent3 = new Student("fathi" , "osama" , "fathi@gmail.com");

					// start a transaction
					session.beginTransaction();
					
					//save the student object
					System.out.println("Saving the Student....");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
					}finally {
						factory.close();
					
					}

	}

}
