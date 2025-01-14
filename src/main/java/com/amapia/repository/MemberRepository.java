package com.amapia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amapia.entity.Amap;
import com.amapia.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	List<Member> findAllByAmapId(Long amapId);

	Optional<Member> existsByEmail(String email);

	Optional<Member> findByEmail(String email);
	
	long countByAmapAndProducerIsNotNull(Amap amap);
	
	long countByAmapAndIndividualIsNotNull(Amap amap);
	
	long countByAmapAndEnterpriseIsNotNull(Amap amap);
}
