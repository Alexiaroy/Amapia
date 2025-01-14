package com.amapia.entity;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name = "activities")
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "activity_id")
	private Long activity_id;

	@Column(nullable = false)
	private String activityName;

	@Column(nullable = false)
	private boolean isActive;

	@Column(nullable = false)
	private String activityDescription;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE) // Indicate only the date (without the time)
	private Date dateTime;

	@Column(name = "start_time")
	private LocalTime startTime; // Starting time of the activity

	@Column(name="end_time")
	private LocalTime endTime;
	
	@Column(name = "location")
	private String location;

	@Column(name = "duration")
	private Integer	duration; // duration (in mins)
	
	@Column (name ="price")
	private Double price; 
	
	@Transient //Means it won't be saved in DB
	private String formattedDuration; // Attribute used to display a proper duration time after fetching it from DB
	
	
	@Column(nullable = false)
	private int availableSpots;
	
	//New attributes to track the registered members
	@Column(nullable = false)
	private int remainingSpots;
	
	@Column(nullable = false)
	private int registeredMembers = 0;

	// Added section for the image //
	@Lob
	@Column(name = "imageData")
	private byte[] imageData;
	private String imageName;
	private String imageType;
	//

	@ManyToOne
	@JoinColumn(name = "producer_id", nullable = false)
	private Producer producer;

	public Activity() {

	}

	public Activity(Long activity_id, String activityName, boolean isActive, String activityDescription, Date dateTime,
			int availableSpots, LocalTime startTime, String location, Integer	duration, Double price, int remainingSpots, int registeredMembers) {
		this.activity_id = activity_id;
		this.activityName = activityName;
		this.isActive = isActive;
		this.activityDescription = activityDescription;
		this.dateTime = dateTime;
		this.availableSpots = availableSpots;
		this.startTime = startTime;
		this.duration = duration;
		this.location = location;
		this.price = price;
		this.remainingSpots = remainingSpots;
		this.registeredMembers = registeredMembers;
	}

	public Long getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(Long activity_id) {
		this.activity_id = activity_id;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getActivityDescription() {
		return activityDescription;
	}

	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getAvailableSpots() {
		return availableSpots;
	}

	public void setAvailableSpots(int availableSpots) {
		this.availableSpots = availableSpots;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	// Added section for the imageData //
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public String getImageName() {
		return imageName;
	}

	public String getImageType() {
		return imageType;
	}
	//

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer	duration) {
		this.duration = duration;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	// Getter and setter to display a proper duration time (ex : 150 min from DB to 2h30)
	public String getFormattedDuration() {
		return formattedDuration;
	}

	public void setFormattedDuration(String formattedDuration) {
		this.formattedDuration = formattedDuration;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getRemainingSpots() {
		return remainingSpots;
	}

	public void setRemainingSpots(int remainingSpots) {
		this.remainingSpots = remainingSpots;
	}

	public int getRegisteredMembers() {
		return registeredMembers;
	}

	public void setRegisteredMembers(int registeredMembers) {
		this.registeredMembers = registeredMembers;
	}
	

}
