package com.amapia.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "volunteers")
public class Volunteer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "volunteer_id")
	private Long volunteer_id;
	
	@Column(nullable=false)
	private boolean active;
	
	@OneToOne(mappedBy = "volunteer", cascade = CascadeType.ALL, orphanRemoval = true)
	private Member member;

	public Volunteer() {
	}

	public Volunteer(Long volunteer_id, boolean active, Member member) {
		this.volunteer_id = volunteer_id;
		this.active = active;
		this.member = member;
	}

	public Long getVolunteer_id() {
		return volunteer_id;
	}

	public void setVolunteer_id(Long volunteer_id) {
		this.volunteer_id = volunteer_id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	
}
