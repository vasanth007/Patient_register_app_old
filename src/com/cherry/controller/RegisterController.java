package com.cherry.controller;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;

import com.cherry.model.*;

@Path("reg")
public class RegisterController
{
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	public Response service(@FormParam("n1") String name,@FormParam("p1") String pass,@FormParam("a2") String address,@FormParam("e1") String email)  
	  {
		System.out.println("hi i am in register ");
		 Register.GetReg(name,pass,address,email);
		 name_1=name;
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
