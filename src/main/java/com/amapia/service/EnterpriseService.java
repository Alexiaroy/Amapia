package com.amapia.service;

import java.util.List;

import com.amapia.entity.Enterprise;

public interface EnterpriseService {
	List<Enterprise> findAll();

	Enterprise save(Enterprise enterprise);

	Enterprise findById(Long id);

	void deleteById(Long id);
}
