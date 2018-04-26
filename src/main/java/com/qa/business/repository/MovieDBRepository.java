package com.qa.business.repository;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Movie;
import com.qa.util.JSONUtil;

public class MovieDBRepository implements IMovieRepository {

	private static final Logger LOGGER = Logger.getLogger(MovieDBRepository.class);
	//static and final because we only want one instance of it
	//same logger class in every application
	//gives us a way to write stuff in our logs
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	//converting objects to JSON and vice versa
	
	@Override
	public String getAllMovies() {
		LOGGER.info("MovieDBRepository getAllMovies");
		//class name, then method
		//construct query
		Query query = manager.createQuery("Select m FROM Movie m"); //m=alias
		//executes query
		Collection<Movie> movies = (Collection<Movie>) query.getResultList();
		//convert it to JSON
		return util.getJSONForObject(movies);
	}

	@Override
	public String getAMovie(Long id) {
		Movie aMovie = getMovie(id);
		//find from the movie class using the id
		//logic check
		if(aMovie != null) {
			return util.getJSONForObject(aMovie);
		}
		else {
			return "{\"message\":\"movie not found\"}";
			//need to use \ escape character
		}
	}

	private Movie getMovie(Long id) {
		return manager.find(Movie.class, id);
	}

	
	
}
