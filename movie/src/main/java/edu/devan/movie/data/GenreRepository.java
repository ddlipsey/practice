package edu.devan.movie.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.devan.movie.domain.Genre;

@Repository("genreRepo")
public interface GenreRepository extends MongoRepository<Genre, String> {
	public List<Genre> findByNameLike(String name);
}
