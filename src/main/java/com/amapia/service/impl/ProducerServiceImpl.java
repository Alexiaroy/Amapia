package com.amapia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.amapia.entity.Amap;
//import com.amapia.entity.Amap;
import com.amapia.entity.Producer;
import com.amapia.repository.ProducerRepository;
import com.amapia.service.ProducerService;

/**
 * Implementation of the ProducerService interface, providing the business logic 
 * for operations related to the Producer entity.
 * 
 * This class interacts with the ProducerRepository to perform CRUD operations, 
 * such as retrieving, saving, updating, and deleting producers.
 * 
 * @author Siham
 */

@Service
//@Transactional
public class ProducerServiceImpl implements ProducerService{

	@Autowired
	private ProducerRepository producerRepository;
	
	@Override
	public List<Producer> findAll() {
		return producerRepository.findAll();
	}
	
//	@Override
//	public List<Producer> findAllByMember_Amap(Amap amap) {
//		return producerRepository.findAllByMember_Amap(amap);
//	}

	@Override
	public Producer save(Producer producer) {
		return producerRepository.save(producer);
	}

	@Override
	public Producer findById(Long id) {
		return producerRepository.findById(id).orElse(null);
	}
	
	@Override
	public void deleteById(Long id) {
		producerRepository.deleteById(id);
	}

}