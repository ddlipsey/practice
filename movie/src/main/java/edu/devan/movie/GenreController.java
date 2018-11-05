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

import edu.devan.movie.data.GenreRepository;
import edu.devan.movie.domain.Genre;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(path="/genres")
public class GenreController {
	
	@Resource(name="genreRepo")
	private GenreRepository genreRepo;
    
    @RequestMapping(method = RequestMethod.GET, produces="application/json") 
    public List<Genre> getGenres(@RequestParam(required=false) String name) {
    	if(name != null && name.length() > 0) {
    		return genreRepo.findByNameLike(name);
    	} else {
    		return genreRepo.findAll();
    	}
    }
    
    @RequestMapping(method = RequestMethod.GET, produces="application/json", value="{id}") 
    public Optional<Genre> getGenre(@PathVariable String id) {
    	return genreRepo.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, consumes="application/json") 
    public ResponseEntity<?> addGenre(@RequestBody Genre genre) {
    	genreRepo.insert(genre);
    	return ResponseEntity.noContent().build();
    }
    
    @RequestMapping(method = RequestMethod.PUT, consumes="application/json") 
    public ResponseEntity<?> updateGenre(@RequestBody Genre genre) {
    	genreRepo.save(genre);
    	return ResponseEntity.noContent().build();
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value="{id}") 
    public ResponseEntity<?> deleteGenre(@PathVariable String id) {
    	Optional<Genre> genre = genreRepo.findById(id);
    	genreRepo.delete(genre.get());
    	return ResponseEntity.noContent().build();
    }

}
