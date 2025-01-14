package com.amapia.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * This class manages the producers of a specific AMAP. 
 * It includes specialized attributes for producers along with their 
 * corresponding getters and setters.
 * 
 * The following attributes : id, contactName, contactPhoneNum, email and password
 * are temporary. They will be removed once inheritance of the "Member" class is implemented
 * 
 * @author Siham
 */
 
 
@Entity
@Table(name="producers")
public class Producer {

	
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="producer_id")
    private Long producer_id;
	
	@Column (nullable=false)
	private String producerCompanyName;
	
	@Column (nullable=false)
	private String producerSiret;

	@OneToOne(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
	private Member member;
	
	@OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Activity> activities;
	
	@OneToMany(mappedBy = "producer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Product> products;
	
	public Producer() {	
	}
	
	public Producer(Long producer_id, String producerCompanyName, String producerSiret, Member member) {
		this.producer_id = producer_id;
		this.producerCompanyName = producerCompanyName;
		this.producerSiret = producerSiret;
		this.member = member;
	}

	public Long getProducer_id() {
		return producer_id;
	}
	
	public void setProducer_id(Long producer_id) {
		this.producer_id = producer_id;
	}

	public String getProducerCompanyName() {
		return producerCompanyName;
	}
	
	public void setProducerCompanyName(String producerCompanyName) {
		this.producerCompanyName = producerCompanyName;
	}

	public String getProducerSiret() {
		return producerSiret;
	}

	public void setProducerSiret(String producerSiret) {
		this.producerSiret = producerSiret;
	}
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

		
}