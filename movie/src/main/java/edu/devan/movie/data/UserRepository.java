package edu.devan.movie.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import edu.devan.movie.domain.User;

@Repository("userRepo")
public interface UserRepository extends MongoRepository<User, String> {
	public List<User> findByLastNameLike(String lastName);
	public List<User> findByLoginIdLike(String loginId);
	public List<User> findByEmailLike(String email);
}
