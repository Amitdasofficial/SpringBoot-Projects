package org.jsp.user.repository;

import java.util.Optional;

import org.jsp.user.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.*;
public interface UserRespository extends JpaRepository<User, Integer>{
     @Query("select u from User u where u.phone=?1 and u.password=?2")
	 Optional<User> verifyUser(long phone,String password);
	
     @Query("select u from User u where u.email=?1 and u.password=?2")
 	 Optional<User> verifyUser(String email,String password);
     
     @Query("select u from User u where u.id=?1 and u.password=?2")
  	 Optional<User> verifyUser(int id,String password);
     @Query( "SELECT u FROM User u WHERE u.name LIKE :prefix%")
     List<User> findByNameStartingWith(String prefix);
}
