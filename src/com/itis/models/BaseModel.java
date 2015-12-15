package com.itis.models;

public abstract class BaseModel {
	protected String additionalUrl;
	protected String tagName;
	
	public String getAdditionalUrl() {
		return additionalUrl;
	}
	
	public String getTagName() {
		return tagName;
	}
	
	public abstract void setAdditionalUrl();
	
	public abstract void setTagName();
}
