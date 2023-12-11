package org.jsp.user.service;

import java.util.List;
import java.util.Optional;

import org.jsp.user.dao.UserDao;
import org.jsp.user.dto.ResponseStructure;
import org.jsp.user.dto.User;
import org.jsp.user.exception.IdNotFoundException;
import org.jsp.user.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
   private UserDao userDao;
	

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setData(userDao.saveUser(user));
		structure.setMessage("User saved succesfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<User>> UpdateUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setData(userDao.updateUser(user));
		structure.setMessage("User updated succesfully");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
	}

       public ResponseEntity<ResponseStructure<User>> findByUserId(int id)
       {
    	   Optional<User> dbUser=userDao.findById(id);
    	   ResponseStructure<User> structure=new ResponseStructure<>();
    	   if(dbUser.isPresent())
    	   {
    		   structure.setData(dbUser.get());
    		   structure.setMessage("User found");
    		   structure.setStatusCode(HttpStatus.OK.value());
    		   return new ResponseEntity<ResponseStructure<User>> (structure,HttpStatus.OK);
    	   }
    	   throw new IdNotFoundException();
       }
	
       public ResponseEntity<ResponseStructure<List<User>>> findAllUsers()
       {
    	   ResponseStructure<List<User>> structure=new ResponseStructure<>();
    	   structure.setMessage("list of all Users");
    	   structure.setData(userDao.findAll());
    	   structure.setStatusCode(HttpStatus.OK.value());
    	   return new ResponseEntity<ResponseStructure<List<User>>> (structure,HttpStatus.OK);
       }
       public ResponseEntity<ResponseStructure<String>> deleteUser(int id)
       {
    	   ResponseStructure<String> structure=new ResponseStructure<>();
    	   Optional<User> dbUser=userDao.findById(id);
    	   if(dbUser.isPresent())
    	   {
    		   userDao.delete(id);
    		   structure.setMessage("User Deleted");
    		   structure.setData("User Found");
    		   structure.setStatusCode(HttpStatus.OK.value());
    		   return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.OK);
    	   }
    	   structure.setMessage("User Not Deleted");
		   structure.setData("Invalid User id");
		   structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		   return new ResponseEntity<ResponseStructure<String>> (structure,HttpStatus.NOT_FOUND);
       }
       
       
       public ResponseEntity<ResponseStructure<User>> verifyUser(long phone,String password)
       {
    	   Optional<User> dbUser=userDao.verifyUser(phone, password);
    	   ResponseStructure<User> structure=new ResponseStructure<>();
    	   if(dbUser.isPresent())
    	   {
    		   structure.setData(dbUser.get());
    		   structure.setMessage("User verify Successfully");
    		   structure.setStatusCode(HttpStatus.OK.value());
    		   return new ResponseEntity<ResponseStructure<User>> (structure,HttpStatus.OK);
    	   }
    	  throw new InvalidCredentialsException();
       }
       
       public ResponseEntity<ResponseStructure<User>> verifyUser(String email,String password)
       {
    	   Optional<User> dbUser=userDao.verifyUser(email, password);
    	   ResponseStructure<User> structure=new ResponseStructure<>();
    	   if(dbUser.isPresent())
    	   {
    		   structure.setData(dbUser.get());
    		   structure.setMessage("User verify Successfully");
    		   structure.setStatusCode(HttpStatus.OK.value());
    		   return new ResponseEntity<ResponseStructure<User>> (structure,HttpStatus.OK);
    	   }
    	  throw new InvalidCredentialsException();
       }
       
       public ResponseEntity<ResponseStructure<User>> verifyUser(int id,String password)
       {
    	   Optional<User> dbUser=userDao.verifyUser(id, password);
    	   ResponseStructure<User> structure=new ResponseStructure<>();
    	   if(dbUser.isPresent())
    	   {
    		   structure.setData(dbUser.get());
    		   structure.setMessage("User verify Successfully");
    		   structure.setStatusCode(HttpStatus.OK.value());
    		   return new ResponseEntity<ResponseStructure<User>> (structure,HttpStatus.OK);
    	   }
    	   throw new InvalidCredentialsException();
       }
       
       
       public ResponseEntity<ResponseStructure<List<User>>> findByNameStartingWith(String prefix)
       {
    	   ResponseStructure<List<User>> structure=new ResponseStructure<>();
    	       structure.setMessage("Name Starting With:");
    	       structure.setData(userDao.findByNameStartingWith(prefix));
    	       structure.setStatusCode(HttpStatus.OK.value());
    	       return new ResponseEntity<ResponseStructure<List<User>>> (structure,HttpStatus.OK);
       }
}
