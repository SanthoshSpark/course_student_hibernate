package com.hibernate.demo;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory sf = null;
		Session s = null;
		Transaction tx = null;
		
		try {
			sf = new Configuration().configure().buildSessionFactory();
			s  = sf.openSession();
			tx = s.beginTransaction();
			
			Course c1 = new Course();
			c1.setName("Java Full Stack");
			
			Student s1 = new Student("std001","Sreenu",23,"Nandiyal",c1);
			Student s2 = new Student("std002","Gunna",24,"Tirupati",c1);
			
			Set<Student> students = new HashSet<Student>();
			
			students.add(s1);
			students.add(s2);
			
			c1.setDescribtion("Hibernate");
			c1.setStudents(students);
			
			s.save(s1);
			s.save(s2);
			
			s.save(c1);
			
			System.out.println("Course Id : "+c1.getId());
			
		}
		catch (HibernateException e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		catch(Exception e){
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		finally {
			if(sf != null)
				if(tx != null)
					tx.commit();
			    sf.close();
			    
			if(s != null)
				s.close();
		}

	}

}
