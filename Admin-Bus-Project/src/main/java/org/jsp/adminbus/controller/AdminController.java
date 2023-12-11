package org.jsp.adminbus.controller;

import org.jsp.adminbus.dto.Admin;
import org.jsp.adminbus.dto.ResponseStructure;
import org.jsp.adminbus.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
        @Autowired
	private AdminService adminService;
        
        //save admin
        @PostMapping("/admins")
        public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin)
        {
        	return adminService.saveAdmin(admin);
        }
        //update admin
        @PutMapping("/admins")
        public  ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin)
        {
        	return adminService.updateAdmin(admin);
        }
        
        //Admin login By phone Password
        @GetMapping("/admins/login-phone-password")
        public ResponseEntity<ResponseStructure<Admin>> loginAdmin(@RequestParam long phone, @RequestParam String password)
        {
        	return adminService.loginAdmin(phone, password);
        }
        
        //Admin login By email Password
        @GetMapping("/admins/login-email-password")
        public ResponseEntity<ResponseStructure<Admin>> loginAdmin(@RequestParam String email,@RequestParam String password)
        {
        	return adminService.loginAdmin(email, password);
        }
        
}
