package com.example.mongo.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mongo.model.User;
/**
 * 
 * @author Ravishankar.kumar
 *
 */
@Repository
public interface UserRepository extends MongoRepository<User, String>{

	Optional<User> findByFirstname(String firstname);


}
