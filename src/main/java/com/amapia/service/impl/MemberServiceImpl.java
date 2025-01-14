package com.amapia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amapia.entity.Amap;
import com.amapia.entity.Member;
import com.amapia.repository.AmapRepository;
import com.amapia.repository.MemberRepository;
import com.amapia.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	@Override
	public Member save(Member member) {
		return memberRepository.save(member);
	}

	@Override
	public Member findById(Long id) {
		return memberRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		memberRepository.deleteById(id);
	}
	

	@Override
	public List<Member> findAllByAmapId(Long amapId) {
	    return memberRepository.findAllByAmapId(amapId);
	}

	@Override
	public boolean existsByEmail(String email) {
		return memberRepository.existsByEmail(email).isPresent();
	}


	@Override
	public Member authenticate(String email, String password, Amap amap) {
		Member member = memberRepository.findByEmail(email).orElse(null);
		if (member == null) {
	        return null;
	    }
		
		if (amap.getMembers() == null || !amap.getMembers().stream().anyMatch(m -> m.getMember_id().equals(member.getMember_id()))) {
	        return null;
	    }
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(password, member.getPassword()) ? member : null;
	}

	@Override
	public Member findByEmail(String email) {
		return memberRepository.findByEmail(email).orElse(null);
	}


	@Override
	public long getNumberOfProducers(Amap amap) {
		return memberRepository.countByAmapAndProducerIsNotNull(amap);
	}

	@Override
	public long getNumberOfIndividuals(Amap amap) {
		return memberRepository.countByAmapAndIndividualIsNotNull(amap);
	}

	@Override
	public long getNumberOfEnterprises(Amap amap) {
		return memberRepository.countByAmapAndEnterpriseIsNotNull(amap);
	}

}
