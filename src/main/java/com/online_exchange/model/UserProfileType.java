package com.online_exchange.model;

public enum UserProfileType {
	CLIENT("CLIENT"),
	ADMINISTRATOR("ADMINISTRATOR"),
	EXCHANGER("EXCHANGER");
	
	String userProfileType;
	
	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}
