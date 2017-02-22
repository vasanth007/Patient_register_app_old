package com.cherry.controller;

import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cherry.model.*;
import com.cherry.pojo.Regist;

@Path("log")
public class LoginController
{
		static String name_1;
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON) 
		public Response doPost(Regist regist)
		{
		   String name = regist.getUsername();
		    String pass = regist.getPass();
			System.out.println("inside login method");
			Boolean loginStatus = Login.GetLogin(name,pass);
			name_1=name;
   
		try{
			java.net.URI location;
			if(loginStatus){
				location = new java.net.URI("../Weluser.jsp");
			}else{
				location = new java.net.URI("../Login.html");
			}
			
			return Response.temporaryRedirect(location).build();

			} catch (URISyntaxException e) {
			e.printStackTrace();

			}
		return null;
		}
		public static String Get()
		{
			return name_1;
			
		}
		
		
		
}
