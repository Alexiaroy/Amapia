package com.amapia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amapia.entity.Volunteer;
import com.amapia.repository.VolunteerRepository;
import com.amapia.service.VolunteerService;

@Service
@Transactional
public class VolunteerServiceImpl implements VolunteerService{

	@Autowired
	private VolunteerRepository volunteerRepository;
	
	@Override
	public List<Volunteer> findAll() {
		return volunteerRepository.findAll();

	}

	@Override
	public Volunteer save(Volunteer volunteer) {
		return volunteerRepository.save(volunteer);
	}

	@Override
	public Volunteer findById(Long id) {
		return volunteerRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		volunteerRepository.deleteById(id);
		
	}

}
