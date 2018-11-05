package edu.devan.movie.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.devan.movie.domain.Movie;

@Repository("movieRepo")
public interface MovieRepository extends MongoRepository<Movie, String> {
	public List<Movie> findByTitleLike(String title);
	public List<Movie> findByGenreLike(String genre);
}
