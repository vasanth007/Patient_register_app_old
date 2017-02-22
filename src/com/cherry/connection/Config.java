package com.cherry.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Config 
{
	public static Session Hiber()
	{
	Configuration configuration= new Configuration();
	configuration.configure("hibernate.cfg.xml");

	SessionFactory factory= configuration.buildSessionFactory();

	Session session=factory.openSession();
	
	return session;

	//Transaction transaction=session.beginTransaction();
	//transaction.begin();

//	Query query = session.createQuery("from student_table");
//	java.util.List list = query.list();
//	System.out.println(list);


	}
	
}
