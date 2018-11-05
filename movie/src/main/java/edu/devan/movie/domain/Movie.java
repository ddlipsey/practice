package edu.devan.movie.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Movie implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private String title;
	private String description;
	private String score;
	private String genre;
	
	public Movie() {
		
	}
	
	public Movie(String title, String description, String score, String genre) {
		this.title = title;
		this.description = description;
		this.score = score;
		this.genre = genre;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", description=" + description + ", score=" + score + ", genre=" + genre + "]";
	}
}
