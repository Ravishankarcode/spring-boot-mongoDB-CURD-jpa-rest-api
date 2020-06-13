package com.example.mongo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.exception.ResourceNotFoundException;
import com.example.mongo.model.User;
import com.example.mongo.repo.UserRepository;
/**
 * 
 * @author Ravishankar.kumar
 *
 */
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRepo;
	/**
	 * API for save user details.
	 * @param user
	 * @return
	 */
    @PostMapping("/users")
    public User saveUserDetails(@Valid @RequestBody User user) {
        return userRepo.save(user);
    }
    /**
     * API for find all user details.
     * @return
     */
    @GetMapping("/users")
    public List<User> getUserDetails() {
        return userRepo.findAll();
    }
    /**
     * API for find user details by firstname
     * @param firstname
     * @return
     */
    @GetMapping("/users/{firstname}")
    public User getUserDetailsByFirstName(@PathVariable(value = "firstname") String firstname) {
        return userRepo.findByFirstname(firstname)
                .orElseThrow(() -> new ResourceNotFoundException("User", "firstname", firstname));
    }
    /**
     * API for update user address and age by firstname
     * @param firstname
     * @param userDetails
     * @return
     */
    @PutMapping("/users/{firstname}")
    public User updateUser(@PathVariable(value = "firstname") String firstname,
                                           @Valid @RequestBody User userDetails) {

    	User user = userRepo.findByFirstname(firstname)
                .orElseThrow(() -> new ResourceNotFoundException("User", "firstname", firstname));

    	user.setAddress(userDetails.getAddress());
    	user.setAge(userDetails.getAge());

        User updatedUser = userRepo.save(user);
        return updatedUser;
    }
    /**
     * API for delete user details by firstname
     * @param firstname
     * @return
     */
    @DeleteMapping("/users/{firstname}")
    public ResponseEntity<?> deleteIUser(@PathVariable(value = "firstname") String firstname) {
    	User user = userRepo.findByFirstname(firstname)
                .orElseThrow(() -> new ResourceNotFoundException("Items", "firstname", firstname));

    	userRepo.delete(user);

        return ResponseEntity.ok().build();
    }
}
