package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.User;

@RestController
public class TestController {

	@GetMapping("/home")
	public String home() {
		System.out.println("This is Home Page");
		return " this is home";
	}

	@GetMapping("/contact")
	public String Contact() {
		System.out.println("Contact Handler loaded");
		return "contact";
	}

	@GetMapping("/sum")
	public String getSum(@RequestParam(name = "n1") int num1, @RequestParam(name = "n2") int num2) {
		return num1 + "+" + num2 + "=" + (num1 + num2);
	}

	@PostMapping("/login")
	public String verify(@RequestParam long phone, @RequestParam String password) {
		if (phone == 9876543210L && password.equals("abc123")) {
			return "login Successful";
		} else {
			return "Invalid phone and password";
		}

	}

	// Print the User Details//
	@PostMapping("/print")
	public String printDetails(@RequestBody User user) {
		System.out.println("User name:" + user.getName());
		System.out.println("User Age:" + user.getAge());
		System.out.println("User Email:" + user.getEmail());
		System.out.println("User Phone :" + user.getPhone());
		System.out.println("User Password:" + user.getPassword());
		return "User details printed successfully";
	}

	// Difference Handler
	@GetMapping("/diff")
	public String differenceofTwo(@RequestParam(name = "n1") int num1, @RequestParam(name = "n2") int num2) {
		return "The diffrence of two number is:" + num1 + "-" + num2 + "=" + (num1 - num2);
	}

	// Multiplication Handler
	@GetMapping("/multi")
	public String multiOfTwo(@RequestParam(name = "n1") int num1, @RequestParam(name = "n2") int num2) {
		int multi = num1 * num2;
		return "The multiplication of two number is:" + multi;
	}

	@GetMapping("/quoti")
	public void quotiOfTwo(@RequestParam(name = "n1") int num1, @RequestParam(name = "n2") int num2) {

		if (num2 != 0) {
			int result = num1 / num2;
			System.out.println("Quotient: " + result);
		} else {
			System.out.println("Error: Division by zero is undefined.");
		}
	}
	
	@GetMapping("/Remainder")
	public String RemainderOfTwo(@RequestParam(name = "n1") int num1, @RequestParam(name = "n2") int num2) {
		int remain = num1%num2;
		return "The multiplication of two number is:" + remain;
	}
}
