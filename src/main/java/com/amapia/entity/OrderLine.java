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
@Table(name="orderlines")
public class OrderLine {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="orderline_id")
    private Long orderline_id;
	@Column (nullable=false)
	private String productName;
	@Column (nullable=false)
	private int quantity;
	@Column (nullable=false)
	private double price;
	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;

	public Long getOrderline_id() {
		return orderline_id;
	}
	public void setOrderline_id(Long orderline_id) {
		this.orderline_id = orderline_id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}


	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}


}
