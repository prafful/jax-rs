package com.jersey.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cts")
public class HelloJersey {
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_HTML)
	public String sayHello(){
		
		String message = "<h1>Prafful Daga</h1>";
		return message;
	}
	
	
	@GET
	@Path("/hi")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHi(){
		
		String message = "Hey Ya from Jersey";
		return message;
	}
	
	@GET
	@Path("/{name}/{location}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(@PathParam("name") String name, @PathParam("location") Integer loc ){
		
		String message = "Hello from " + name + " from " + loc;
		return message;
	}
	
	

}
