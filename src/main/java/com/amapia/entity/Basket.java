package com.amapia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "baskets")
public class Basket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	public enum basketType{
		veggie, fruit, mix
	};
	
	   @ManyToOne
	    @JoinColumn(name = "producer_id", nullable = false)
	    private Producer producer;
	   
	    @Column(nullable = false)
	    private String name;

	    @Column(nullable = false)
	    private boolean isActive;

	    @Column(nullable = false)
	    private String description;
	    
	    @Lob
		@Column(name = "imageData")
		private byte[] imageData;
		private String imageName;
		private String imageType;

	    private basketType basketType;
	    
	    public byte[] getImageData() {
			return imageData;
		}

		public void setImageData(byte[] imageData) {
			this.imageData = imageData;
		}

		public String getImageName() {
			return imageName;
		}

		public void setImageName(String imageName) {
			this.imageName = imageName;
		}

		public String getImageType() {
			return imageType;
		}

		public void setImageType(String imageType) {
			this.imageType = imageType;
		}

		public boolean isPublished() {
			return isPublished;
		}

		public void setPublished(boolean isPublished) {
			this.isPublished = isPublished;
		}

		private boolean isPublished;
	    
	    public Long getId() {
			return id;
		}

		public basketType getBasketType() {
			return basketType;
		}

		public void setBasketType(basketType basketType) {
			this.basketType = basketType;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Producer getProducer() {
			return producer;
		}

		public void setProducer(Producer producer) {
			this.producer = producer;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public boolean isActive() {
			return isActive;
		}

		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		@Column(nullable = false)
	    private Double price;

	    @Column(nullable = false)
	    private int stock;
	    
}
