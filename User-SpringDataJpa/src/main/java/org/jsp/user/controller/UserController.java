package org.jsp.user.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.user.dto.ResponseStructure;
import org.jsp.user.dto.User;
import org.jsp.user.repository.UserRespository;
import org.jsp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	// Save User
	@PostMapping(value = "/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	// Update User
	@PutMapping("/users")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user) {

		return service.saveUser(user);
	}

	// findUserById
	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> findUserById(@PathVariable int id) {

		return service.findByUserId(id);
	}

	// FindAll Users

	@GetMapping("/users")
	public ResponseEntity<ResponseStructure<List<User>>> findAllUsers() {
		return service.findAllUsers();
	}

	// Delete Users
	@DeleteMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id) {
       return service.deleteUser(id);
	}
      @PostMapping("/users/verify-phone-password")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam long phone,@RequestParam String password)
	{
		return service.verifyUser(phone, password);
	}
      @PostMapping("/users/verify-email-password")
  	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam String email,@RequestParam String password)
  	{
  		return service.verifyUser(email, password);
  	}
      @PostMapping("/users/verify-id-password")
    	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam int id,@RequestParam String password)
    	{
    		return service.verifyUser(id, password);
    	}
      @GetMapping("/users/prefix")
      public ResponseEntity<ResponseStructure<List<User>>> findByNameStartingWith(@RequestParam String  prefix)
      {
    	  return service.findByNameStartingWith(prefix);
      }
}
