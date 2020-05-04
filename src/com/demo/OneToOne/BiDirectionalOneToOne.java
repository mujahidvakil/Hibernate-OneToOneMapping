package com.demo.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class BiDirectionalOneToOne {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session=null;
		try {
			session=sf.getCurrentSession();
			session.beginTransaction();
			InstructorDetail ind=session.get(InstructorDetail.class, 2);
			ind.getInstructor().setInstructorDetail(null);
			System.out.println("instructor Detail"+ind);
			System.out.println("____________________________");
			System.out.println("instructor "+ind.getInstructor());
			session.delete(ind);
			
			session.getTransaction().commit();
		} finally {
			session.close();
			sf.close();
		}
		

	}

}
