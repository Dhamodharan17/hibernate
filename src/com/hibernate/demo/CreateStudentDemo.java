package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
	
		// Step 1
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// Step 2
		Session session = factory.getCurrentSession();
		
		try {
			Student student = new Student("Karthik","Sundar","kartik@email.com");
			
			session.beginTransaction();
			
			session.save(student);
			
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		

	}

}
