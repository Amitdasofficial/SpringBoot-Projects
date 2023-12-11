package org.jsp.adminbus.dao;

import java.util.Optional;

import org.jsp.adminbus.dto.Admin;
import org.jsp.adminbus.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
	@Autowired
	private AdminRepository adminRepository;

	// save admin
	public Admin registerAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	// Admin Login by phone password
	public Optional<Admin> loginAdmin(long phone, String password) {
		return adminRepository.loginAdmin(phone, password);
	}

	// admin login by email password
	public Optional<Admin> loginAdmin(String email, String password) {
		return adminRepository.loginAdmin(email, password);
	}

	// Update the Admin details
	public Admin updateAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	// findAdmin By Id
	public Optional<Admin> findById(int id) {
		return adminRepository.findById(id);
	}
}
