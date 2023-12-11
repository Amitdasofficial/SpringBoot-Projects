package com.jpa.test;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entity.User;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);

//	                                      //Save Single user
//	User user=new User();
//	user.setName("Amit");
//	user.setCity("Kolkata");
//	user.setDesignation("Java Developer");
//	   User user1 =userRepository.save(user);
//	   System.out.println(user1);

	                                          	// Saving Multiple User
//	User u=new User();
//	u.setName("Rohit");
//	u.setCity("Mumbai");
//	u.setDesignation("Cricketer");
//	
//	User u1=new User();
//	u1.setName("Kohli");
//	u1.setCity("Delhi");
//	u1.setDesignation("Cricketer");
//	List<User> users=List.of(u,u1);
//	Iterable<User> result=userRepository.saveAll(users);
//	result.forEach(user->
//	{
//		System.out.println(user);
//	});
//	System.out.println("Done");

		                                       // Update User
//	   Optional<User> optional=userRepository.findById(3);
//	   User user=optional.get();
//	   user.setName("Rohit Sharma");
//	   user.setCity("Mumbai");
//	   user.setDesignation("Legend Cricketer");
//	   User result=userRepository.save(user);
//	   System.out.println(result);

		                             // find All User
//	   Iterable<User> itr=userRepository.findAll();
//	   itr.forEach(user->{System.out.println(user);});

		                             // Delete User By Id
//	   userRepository.deleteById(1);
//	   System.out.println("User Deleted successfully");
//	   
		// Delete All user
//	          Iterable<User> allusers=userRepository.findAll();
//	          allusers.forEach(user->{System.out.println(user);});
//	          userRepository.deleteAll();
		
//		                                //Find by Name
//		List<User> result = userRepository.findByName("Kohli");
//		System.out.println(result);
		
		      //find By city and Name
		 List<User> result= userRepository.findByNameAndCity("Kohli", "Delhi");
		System.out.println(result);
	}

}
