package com.amapia.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amapia.entity.Admin;

import com.amapia.repository.AdminRepository;
import com.amapia.service.AdminService;


@Service

public class AdminServiceImpl implements AdminService {
	@Autowired
	 AdminRepository adminRepository;
@Override
	public Admin authenticate(String email, String password) {
	Optional<Admin> admina = findByEmail(email);
	
		Admin admin = admina.get();

		System.out.println("Mot de passe fourni par l'utilisateur : " + password);
		System.out.println("Mot de passe dans la base : " + admin.getPassword());

	
		if (password.equals(admin.getPassword())) {
			System.out.println("succès");
			return admin;

		} else {
			System.out.println("Erreur : Le mot de passe est incorrect.");

			return null;
		}
	}

	@Override
	public Optional<Admin> findByEmail(String email) {
		return adminRepository.findByEmail(email);
	}

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}
}
