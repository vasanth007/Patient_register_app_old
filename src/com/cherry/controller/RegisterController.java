package com.cherry.controller;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cherry.connection.Config;
import com.cherry.model.*;
import com.cherry.pojo.Regist;

@Path("reg")
public class RegisterController
{
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON) 
	public Response service(Regist regist)  
	  {
		System.out.println("hi i am in register ");
		
		
		System.out.println(regist.getUsername());
		
		Session session=Config.Hiber();
		Transaction transaction = session.beginTransaction();
			session.save(regist);
		transaction.commit();
		
		session.close();
		
//	 Register.GetReg(name,pass,address,email);
	//	 name_1=name;
			try{
				java.net.URI location;
				location = new java.net.URI("../Reg.jsp");
				return Response.temporaryRedirect(location).build();

				} catch (URISyntaxException e) {
				e.printStackTrace();

				}
			return null;
	  }
	
	static String name_1;	
	
	public static String getName()
	{
		return name_1;
	}
	
}
