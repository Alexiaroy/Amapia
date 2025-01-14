package com.amapia.service;

import java.util.List;

import com.amapia.entity.Individual;

public interface IndividualService {
	List<Individual> findAll();

	Individual save(Individual individual);

	Individual findById(Long id);

	void deleteById(Long id);
}
