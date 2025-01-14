package com.amapia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amapia.entity.Admin;
@Service
public interface AdminService {
	
	List<Admin> findAll();
	Admin authenticate(String email, String password);
	Optional<Admin> findByEmail(String email);
}
