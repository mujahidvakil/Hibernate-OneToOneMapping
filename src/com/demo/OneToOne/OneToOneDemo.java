package com.demo.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class OneToOneDemo {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session=null;
		try {
			session=sf.getCurrentSession();
			Instructor ins=new Instructor("ajahar","Ansari","majahar@gmail.com");
			InstructorDetail insD=new InstructorDetail("www.youtube1.com","got");
			ins.setInstructorDetail(insD);
			session.beginTransaction();
			session.save(ins);
			session.getTransaction().commit();
			session.close();
		} finally {
			sf.close();
		}

	}

}
