package com.cherry.model;


import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.cherry.connection.Config;


public class Login 
{

	public static Boolean GetLogin(String username, String password) 
	{
		Session session = Config.Hiber();
        Transaction t = session.beginTransaction();

        Query query = session.createQuery("from Regist where username=:u and password=:p");
        query.setParameter("u",username);
        query.setParameter("p",password);
        List list=query.list();
        System.out.println(list);
        t.commit();
        session.close();
        if(list.toString()=="[]")
        {
        return false;
        }
        else
       	return true;
        
}
	}

