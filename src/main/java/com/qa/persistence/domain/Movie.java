package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movie {

	//attributes
	@Id //control+space to import
	@GeneratedValue
	private Long id;
	private String title;
	private String genre;
	private String rating;
	
	
	//constructors
	public Movie() {
	}
	
	public Movie(String title, String genre, String rating) {
		this.title = title;
		this.genre = genre;
		this.rating = rating;
	}

	//getters and setters
	public Long getId() {
		return id;
	}
	//no need setId because we dont want to change it
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	
}
