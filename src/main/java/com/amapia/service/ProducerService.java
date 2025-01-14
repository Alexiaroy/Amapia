package com.amapia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amapia.entity.Amap;
//import com.amapia.entity.Amap;
import com.amapia.entity.Producer;

/**
 * This interface defines the contract for operations related to the Producer entity.
 * It separates the business logic from data persistence to ensure clean architecture
 * and maintainable code.
 * 
 * This service provides CRUD methods operations on Producer entities, such as
 * saving, finding, and deleting producers.
 * 
 * @author Siham
 */
@Service
public interface ProducerService {

	List<Producer> findAll();
	
//	List<Producer> findAllByMember_Amap(Amap amap);

	Producer save(Producer producer);

	Producer findById(Long id);
	
	void deleteById(Long id);
	
}