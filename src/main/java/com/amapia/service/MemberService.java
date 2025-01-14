package com.amapia.service;

import java.util.List;

import com.amapia.entity.Amap;
import com.amapia.entity.Member;

public interface MemberService {

	List<Member> findAll();

	Member save(Member member);

	Member findById(Long id);

	void deleteById(Long id);

	List<Member> findAllByAmapId(Long amapId);

	boolean existsByEmail(String email);

	
	Member findByEmail(String email);
	
	Member authenticate(String email, String password, Amap amap);

	
	long getNumberOfProducers(Amap amap);
	
	long getNumberOfIndividuals(Amap amap);
	
	long getNumberOfEnterprises(Amap amap);

}
