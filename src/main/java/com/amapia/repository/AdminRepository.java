package com.amapia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amapia.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	List<Admin> findAll();
	Optional<Admin> findByEmail(String email);

}
