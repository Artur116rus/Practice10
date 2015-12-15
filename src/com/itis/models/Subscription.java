package com.itis.models;

public class Subscription extends BaseModel {
	
	private String email;
	
	public Subscription(String email) {
		setAdditionalUrl();
		setTagName();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setAdditionalUrl() {
		additionalUrl = "/";
	}

	@Override
	public void setTagName() {
		tagName = "/com/mvideo/subscription/UserSubscriptionsFormHandler.subscribeUserOnNews";
		
	}
	
	

}
