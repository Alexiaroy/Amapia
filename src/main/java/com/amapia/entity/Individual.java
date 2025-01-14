package com.amapia.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "individual")
public class Individual {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "individual_id")
	private Long individual_id;
	
//	@Column(nullable=false)
//	private Date membershipStartDate;
//	
//	@Column(nullable=false)
//	private Boolean paymentStatus;

	@OneToOne(mappedBy = "individual", cascade = CascadeType.ALL, orphanRemoval = true)
	private Member member;
	
	public Long getIndividual_id() {
		return individual_id;
	}

	public void setIndividual_id(Long individual_id) {
		this.individual_id = individual_id;
	}

//	public Date getMembershipStartDate() {
//		return membershipStartDate;
//	}
//
//	public void setMembershipStartDate(Date membershipStartDate) {
//		this.membershipStartDate = membershipStartDate;
//	}
//
//	public Boolean getPaymentStatus() {
//		return paymentStatus;
//	}
//
//	public void setPaymentStatus(Boolean paymentStatus) {
//		this.paymentStatus = paymentStatus;
//	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	
}
