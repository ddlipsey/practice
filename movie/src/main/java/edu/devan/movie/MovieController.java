package edu.devan.movie;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.devan.movie.data.MovieRepository;
import edu.devan.movie.domain.Movie;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path="/movies")
public class MovieController {
	
	@Resource(name="movieRepo")
	private MovieRepository movieRepo;
    
    @RequestMapping(method = RequestMethod.GET, produces="application/json") 
    public List<Movie> getMovies(@RequestParam(required=false) String title, @RequestParam(required=false) String genre) {
    	if(title != null && title.length() > 0) {
    		return movieRepo.findByGenreLike(genre);
    	} else if(genre != null && genre.length() > 0) {
    		return movieRepo.findByGenreLike(genre);
    	} else {
    		return movieRepo.findAll();
    	}
    }
    
    @RequestMapping(method = RequestMethod.GET, produces="application/json", value="{id}") 
    public Optional<Movie> getMovie(@PathVariable String id) {
    	return movieRepo.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes="application/json") 
    public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
    	movieRepo.insert(movie);
    	return ResponseEntity.noContent().build();
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes="application/json") 
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie) {
    	movieRepo.save(movie);
    	return ResponseEntity.noContent().build();
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value="{id}") 
    public ResponseEntity<?> deleteMovie(@PathVariable String id) {
    	Optional<Movie> movie = movieRepo.findById(id);
    	movieRepo.delete(movie.get());
    	return ResponseEntity.noContent().build();
    }

}
