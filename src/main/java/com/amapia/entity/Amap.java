package com.amapia.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="amaps")
public class Amap {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String address;
	
	@Column(nullable=false, unique = true)
	private String linkName;
	
	@Column(nullable=false)
	private String contactName; 
	
	@Column(nullable=true)
	private String contactFirstname;
	
	@Column(nullable=false)
	private String contactPhoneNum;
	
	@Column(nullable=false, unique = true)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String amapSiret;
	
	@Column(nullable=false)
	private Date subLastPaymentDate;
	
	@Column(nullable=false)
	private Date dateCreated;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="subscription_id", nullable=false)
	private Subscription subscription;
	
	@PrePersist
    @PreUpdate
    private void encodePassword() {
        if (this.password != null && !this.password.startsWith("$2a$")) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            this.password = encoder.encode(this.password);
        }
    }

	//One-To-Many RelationShip
	@OneToMany(mappedBy = "amap")
	private List<Member> members = new ArrayList<Member>();
	
	// Amap custom

	private String logoText;

	@Lob
	private byte[] logoImgData;
	private String logoImgName;
	private String logoImgType;

	@Column(length = 1000)
	private String news;

	private String aboutSectionTitle;

	@Column(length = 2000)
	private String aboutSectionText;

	@Lob
	private byte[] aboutSectionImgData;
	private String aboutSectionImgName;
	private String aboutSectionImgType;

	private String subSectionTitle;

	@Column(length = 1000)
	private String subSectionText;

	@Lob
	private byte[] bannerImgData;
	private String bannerImgName;
	private String bannerImgType;
	
	private boolean bannerChoice;
	
	private ColorType bannerColor;
	
	public Amap() {
	}

	public Amap(String name, String address, String contactName, String contactFirstname,
			String contactPhoneNum, String email, String password, String amapSiret) {
		this.name = name;
		this.address = address;
		this.contactName = contactName;
		this.contactFirstname = contactFirstname;
		this.contactPhoneNum = contactPhoneNum;
		this.email = email;
		this.password = password;
		this.amapSiret = amapSiret;
		this.bannerChoice = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhoneNum() {
		return contactPhoneNum;
	}

	public void setContactPhoneNum(String contactPhoneNum) {
		this.contactPhoneNum = contactPhoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAmapSiret() {
		return amapSiret;
	}

	public void setAmapSiret(String amapSiret) {
		this.amapSiret = amapSiret;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getContactFirstname() {
		return contactFirstname;
	}

	public void setContactFirstname(String contactFirstname) {
		this.contactFirstname = contactFirstname;
	}

	public Date getSubLastPaymentDate() {
		return subLastPaymentDate;
	}

	public void setSubLastPaymentDate(Date subLastPaymentDate) {
		this.subLastPaymentDate = subLastPaymentDate;
	}

	public String getLogoText() {
		return logoText;
	}

	public void setLogoText(String logoText) {
		this.logoText = logoText;
	}

	public byte[] getLogoImgData() {
		return logoImgData;
	}

	public void setLogoImgData(byte[] logoImgData) {
		this.logoImgData = logoImgData;
	}

	public String getLogoImgName() {
		return logoImgName;
	}

	public void setLogoImgName(String logoImgName) {
		this.logoImgName = logoImgName;
	}

	public String getLogoImgType() {
		return logoImgType;
	}

	public void setLogoImgType(String logoImgType) {
		this.logoImgType = logoImgType;
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	public String getAboutSectionTitle() {
		return aboutSectionTitle;
	}

	public void setAboutSectionTitle(String aboutSectionTitle) {
		this.aboutSectionTitle = aboutSectionTitle;
	}

	public String getAboutSectionText() {
		return aboutSectionText;
	}

	public void setAboutSectionText(String aboutSectionText) {
		this.aboutSectionText = aboutSectionText;
	}

	public byte[] getAboutSectionImgData() {
		return aboutSectionImgData;
	}

	public void setAboutSectionImgData(byte[] aboutSectionImgData) {
		this.aboutSectionImgData = aboutSectionImgData;
	}

	public String getAboutSectionImgName() {
		return aboutSectionImgName;
	}

	public void setAboutSectionImgName(String aboutSectionImgName) {
		this.aboutSectionImgName = aboutSectionImgName;
	}

	public String getAboutSectionImgType() {
		return aboutSectionImgType;
	}

	public void setAboutSectionImgType(String aboutSectionImgType) {
		this.aboutSectionImgType = aboutSectionImgType;
	}

	public String getSubSectionTitle() {
		return subSectionTitle;
	}

	public void setSubSectionTitle(String subSectionTitle) {
		this.subSectionTitle = subSectionTitle;
	}

	public String getSubSectionText() {
		return subSectionText;
	}

	public void setSubSectionText(String subSectionText) {
		this.subSectionText = subSectionText;
	}

	public byte[] getBannerImgData() {
		return bannerImgData;
	}

	public void setBannerImgData(byte[] bannerImgData) {
		this.bannerImgData = bannerImgData;
	}

	public String getBannerImgName() {
		return bannerImgName;
	}

	public void setBannerImgName(String bannerImgName) {
		this.bannerImgName = bannerImgName;
	}

	public String getBannerImgType() {
		return bannerImgType;
	}

	public void setBannerImgType(String bannerImgType) {
		this.bannerImgType = bannerImgType;
	}

	public ColorType getBannerColor() {
		return bannerColor;
	}

	public void setBannerColor(ColorType bannerColor) {
		this.bannerColor = bannerColor;
	}

	public boolean isBannerChoice() {
		return bannerChoice;
	}

	public void setBannerChoice(boolean bannerChoice) {
		this.bannerChoice = bannerChoice;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	
	
	

}
