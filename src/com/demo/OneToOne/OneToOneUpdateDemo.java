package com.demo.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class OneToOneUpdateDemo {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session=null;
		try {
			session=sf.getCurrentSession();
			session.beginTransaction();
			Instructor ins=session.get(Instructor.class, 2);
			System.out.println("update the objetc");
			ins.setEmail("md@gmail.com"); //update the email
			//session.delete(ins);  //delete the object 
			System.out.println(ins);
			session.getTransaction().commit();
		} finally {
			session.close();
			sf.close();
			}

	}

}
