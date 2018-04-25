package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.service.IMovieService;

//activate this class
@Path("/movie")
public class MovieEndpoint {
	//instance variable
	@Inject
	private IMovieService service;
	
	//activate the method
	@GET
	@Path("/json")
	@Produces ("application/json")
	public String getAllMovies() {
		return service.getAllMovies();
	//returns JSON string, and shows it in PostMan
	}
}
