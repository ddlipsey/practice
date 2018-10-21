package edu.devan.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The movie application user stories:
 * <p>
 * 1. As a movie app admin I should be able to add/update/remove movies. A movie
 * should have a title, description and genre. 
 * <p>
 * 2. As a registered movie app user I should be able to see a list of movies with details.
 * I should be able to search by title, description and movies I've seen. I
 * should be able to sort by title, description, genre and score. 3. As a movie
 * app user I should be able to select a movie and mark it as a movie I've seen.
 * Any movie I have seen must include my score.
 * 3. As a non-registered movie app user, I should be able to register myself. Registration should
 * capture first name, last name, e-mail, login id and password. I should also be able to automatically
 * register using my google account via OAUTH.
 * @author Devan
 *
 */
@SpringBootApplication
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}
}
