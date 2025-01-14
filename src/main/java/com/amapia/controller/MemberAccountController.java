package com.amapia.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amapia.entity.Amap;
import com.amapia.entity.Enterprise;
import com.amapia.entity.Individual;
import com.amapia.entity.Member;
import com.amapia.entity.MemberType;
import com.amapia.entity.Producer;
import com.amapia.entity.Volunteer;
import com.amapia.service.AmapAccountService;
import com.amapia.service.MemberService;

@Controller
@RequestMapping("/")
public class MemberAccountController {

	private final AmapAccountService amapAccountService;
	private final MemberService memberService;

	public MemberAccountController(AmapAccountService amapAccountService, MemberService memberService) {
		this.amapAccountService = amapAccountService;
		this.memberService = memberService;
	}

	private void prepareSignupModel(String linkName, String signupType, Object specificMemberType, Model model) {
	    Amap amap = amapAccountService.findByLinkName(linkName);
	    model.addAttribute("amap", amap);
	    model.addAttribute("member", new Member());
	    model.addAttribute(signupType.toLowerCase(), specificMemberType);
	    model.addAttribute("signupType", signupType);
	}
	
	private Member updateCommonMemberInfo(Long id, Member member) {
	    Member existingMember = memberService.findById(id);
	    existingMember.setFirstName(member.getFirstName());
	    existingMember.setLastName(member.getLastName());
	    existingMember.setEmail(member.getEmail());
	    existingMember.setAddress(member.getAddress());
	    existingMember.setPhoneNumber(member.getPhoneNumber());
	    existingMember.setDateLastModified(new Date());
	    return existingMember;
	}

	@GetMapping("/{linkName}/signup_{type}")
	public String showSignupForm(@PathVariable String linkName, @PathVariable String type, Model model) {
	    switch (type.toLowerCase()) {
	        case "individual":
	            prepareSignupModel(linkName, "INDIVIDUAL", new Individual(), model);
	            break;
	        case "enterprise":
	            prepareSignupModel(linkName, "ENTERPRISE", new Enterprise(), model);
	            break;
	        case "volunteer":
	            prepareSignupModel(linkName, "VOLUNTEER", new Volunteer(), model);
	            break;
	        case "producer":
	            prepareSignupModel(linkName, "PRODUCER", new Producer(), model);
	            break;
	        default:
	            throw new IllegalArgumentException("Type d'inscription non pris en charge");
	    }
	    return "/members/signupForm";
	}

	@PostMapping("/{linkName}/signup_{type}")
	public String saveMember(
	        @PathVariable String linkName,
	        @PathVariable String type,
	        @ModelAttribute Member member,
	        @ModelAttribute Individual individual,
	        @ModelAttribute Enterprise enterprise,
	        @ModelAttribute Volunteer volunteer,
	        @ModelAttribute Producer producer,
	        Model model) {

	    Amap amap = amapAccountService.findByLinkName(linkName);
	    member.setAmap(amap);
	    member.setDateCreated(new Date());
	    member.setDateLastModified(new Date());
	    member.setMemberShipFee(true);
	    member.setAccountStatus(true);

	    switch (type.toLowerCase()) {
	        case "individual":
	            if (individual != null) {
	                member.setMemberType(MemberType.INDIVIDUAL);
	                member.setIndividual(individual);
	                individual.setMember(member);
	            } else {
	                throw new IllegalArgumentException("Type d'inscription non pris en charge pour individual");
	            }
	            break;
	        case "enterprise":
	            if (enterprise != null) {
	                member.setMemberType(MemberType.ENTERPRISE);
	                member.setEnterprise(enterprise);
	                enterprise.setMember(member);
	            } else {
	                throw new IllegalArgumentException("Type d'inscription non pris en charge pour enterprise");
	            }
	            break;
	        case "volunteer":
	            if (volunteer != null) {
	                member.setMemberType(MemberType.VOLUNTEER);
	                member.setVolunteer(volunteer);
	                volunteer.setMember(member);
	            } else {
	                throw new IllegalArgumentException("Type d'inscription non pris en charge pour volunteer");
	            }
	            break;
	        case "producer":
	            if (producer != null) {
	                member.setMemberType(MemberType.PRODUCER);
	                member.setProducer(producer);
	                producer.setMember(member);
	            } else {
	                throw new IllegalArgumentException("Type d'inscription non pris en charge pour producer");
	            }
	            break;
	        default:
	            throw new IllegalArgumentException("Type d'inscription non pris en charge : " + type);
	    }

	    memberService.save(member);
	    return "redirect:/" + linkName;
	}



	@GetMapping("/{linkName}/update/{id}")
	public String updateMember(@PathVariable String linkName, @PathVariable Long id, Model model) {
	    Amap amap = amapAccountService.findByLinkName(linkName);
	    Member member = memberService.findById(id);
	    
	    model.addAttribute("amap", amap);
	    model.addAttribute("member", member);

	    String signupType = " ";
	    switch (member.getMemberType()) {
	        case ENTERPRISE : {
	            model.addAttribute("enterprise", member.getEnterprise());
	            signupType = "ENTERPRISE";
	            break;
	        }
	        case INDIVIDUAL : {
	            model.addAttribute("individual", member.getIndividual());
	            signupType = "INDIVIDUAL";
	            break;
	        }
	        case VOLUNTEER : {
	            model.addAttribute("volunteer", member.getVolunteer());
	            signupType = "VOLUNTEER";
	            break;
	        }
	        case PRODUCER : {
	            model.addAttribute("producer", member.getProducer());
	            signupType = "PRODUCER";
	            break;
	        }
	        default : 
	        	throw new IllegalArgumentException("Type de membre non pris en charge");
	    }

	    model.addAttribute("signupType", signupType);
	    
	    return "/members/updateForm";
	}

	@PostMapping("/{linkName}/update_{type}/{id}")
	public String updateMemberDetails(
	        @PathVariable String linkName,
	        @PathVariable Long id,
	        @PathVariable String type,
	        @ModelAttribute Member member,
	        @ModelAttribute Individual individual,
	        @ModelAttribute Enterprise enterprise,
	        @ModelAttribute Volunteer volunteer,
	        @ModelAttribute Producer producer) {

	    Member existingMember = updateCommonMemberInfo(id, member);

	    switch (type.toLowerCase()) {
	        case "enterprise":
	        	if (enterprise != null) {
	                Enterprise existingEnterprise = existingMember.getEnterprise();
	                existingEnterprise.setCompanyName(enterprise.getCompanyName());
	                existingEnterprise.setNumberOfEmployees(enterprise.getNumberOfEmployees());
	            }
	            break;

	        case "individual":
	        	if (individual != null) {
	                Individual existingIndividual = existingMember.getIndividual();
	                // field to update
	            }
	            break;

	        case "volunteer":
	        	if (volunteer != null){
	                Volunteer existingVolunteer = existingMember.getVolunteer();
	                existingVolunteer.setActive(volunteer.isActive());
	            }
	            break;

	        case "producer":
	        	if (producer != null) {
	                Producer existingProducer = existingMember.getProducer();
	                existingProducer.setProducerCompanyName(producer.getProducerCompanyName());
	                existingProducer.setProducerSiret(producer.getProducerSiret());
	            }
	            break;

	        default:
	            throw new IllegalArgumentException("Invalid member type: " + type);
	    }

	    memberService.save(existingMember);
	    return "redirect:/" + linkName + "/members";
	}

}
