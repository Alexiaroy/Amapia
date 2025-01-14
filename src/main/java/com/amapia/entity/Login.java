package com.amapia.entity;

public class Login {
	  private String username;
	  private String password;
private long AmapId;



	public long getAmapId() {
	return AmapId;
}

public void setAmapId(long amapId) {
	AmapId = amapId;
}

	public String getUsername() {
	  return username;
	  }

	  public void setUsername(String username) {
	  this.username = username;
	  }

	  public String getPassword() {
	  return password;
	  }

	  public void setPassword(String password) {
	  this.password = password;
	  }

	}

