package edu.devan.movie;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.devan.movie.data.UserRepository;
import edu.devan.movie.domain.User;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Resource(name = "userRepo")
	private UserRepository userRepo;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<User> getUsers(@RequestParam(required = false) String lastName,
			@RequestParam(required = false) String loginId, @RequestParam(required = false) String email) {
		if (lastName != null && lastName.length() > 0) {
			return userRepo.findByLastNameLike(lastName);
		} else if (loginId != null && loginId.length() > 0) {
			return userRepo.findByLoginIdLike(loginId);
		} else if (email != null && email.length() > 0) {
				return userRepo.findByEmailLike(email);
		} else {
			return userRepo.findAll();
		}
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "{id}")
	public Optional<User> getUser(@PathVariable String id) {
		return userRepo.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> addUser(@RequestBody User movie) {
		userRepo.insert(movie);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<?> updateUser(@RequestBody User movie) {
		userRepo.save(movie);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.DELETE, consumes = "application/json")
	public ResponseEntity<?> deleteUser(@RequestBody User movie) {
		userRepo.delete(movie);
		return ResponseEntity.noContent().build();
	}

}
