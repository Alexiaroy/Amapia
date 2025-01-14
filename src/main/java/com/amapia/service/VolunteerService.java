package com.amapia.service;

import java.util.List;

import com.amapia.entity.Volunteer;

public interface VolunteerService {

	List<Volunteer> findAll();

	Volunteer save(Volunteer volunteer);

	Volunteer findById(Long id);

	void deleteById(Long id);
	
}
