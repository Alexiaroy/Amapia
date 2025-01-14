package com.amapia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
    private Long order_id;
	@ManyToOne

    @JoinColumn(name = "amap_id", nullable = true)
	private Amap amap;
	@Column (nullable=false)
	private double price;
	@ManyToOne
	@JoinColumn(name = "member_id", nullable = true)
	private Member member;
	
	private boolean status;
	

	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public Amap getAmap() {
		return amap;
	}
	public void setAmap(Amap amap) {
		this.amap = amap;
	}
}

