package com.amapia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amapia.entity.Individual;
import com.amapia.repository.IndividualRepository;
import com.amapia.service.IndividualService;

@Service
public class IndividualServiceImpl  implements IndividualService{

	@Autowired
	private IndividualRepository individualRepository;
	
	@Override
	public List<Individual> findAll() {
		return individualRepository.findAll();
	}

	@Override
	public Individual save(Individual individual) {
		return individualRepository.save(individual);
	}

	@Override
	public Individual findById(Long id) {
		return individualRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		individualRepository.deleteById(id);
		
	}

}
