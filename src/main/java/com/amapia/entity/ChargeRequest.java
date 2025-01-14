package com.amapia.entity;

public class ChargeRequest {
    private String token;
    private Long amount;
    private String description;
    public enum Currency {
        EUR, USD;
    }
    private Currency currency;
    
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}


    
}