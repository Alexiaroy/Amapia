package com.amapia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amapia.entity.Enterprise;
import com.amapia.repository.EnterpriseRepository;
import com.amapia.service.EnterpriseService;

@Service
public class EnterpriseServiceImpl  implements EnterpriseService{

	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	@Override
	public List<Enterprise> findAll() {
		return enterpriseRepository.findAll();
	}

	@Override
	public Enterprise save(Enterprise enterprise) {
		return enterpriseRepository.save(enterprise);
	}

	@Override
	public Enterprise findById(Long id) {
		return enterpriseRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		enterpriseRepository.deleteById(id);
		
	}

}
