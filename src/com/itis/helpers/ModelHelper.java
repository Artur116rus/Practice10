package com.itis.helpers;

import org.openqa.selenium.By;

import com.itis.models.BaseModel;
import com.itis.models.Subscription;
import com.itis.models.User;

public class ModelHelper extends HelperWithWebDriverBase {

	public ModelHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public <T extends BaseModel> void createModel(T model) {
		manager.getNavigationHelper().openMainPage(model.getAdditionalUrl());
		fillPostForm(model);
		submit(model.getTagName());
		manager.getNavigationHelper().redirectToMainPage();
	}
	
	private void submit(String tagName) {
		click(By.name(tagName));
	}

	private <T extends BaseModel> void fillPostForm(T model) {
		if (model instanceof User) {
			User user = (User) model;
			type(By.id("register-form-name-input"), user.getName());
			type(By.id("register-form-email"), user.getEmail());
			type(By.id("register-form-password"), user.getPassword());
			type(By.id("register-form-confirm-password"),
					user.getPasswordConfirmation());
			check(By.cssSelector("span.fake-checkbox"));
		} else {
			Subscription subscription = (Subscription) model;
			type(By.id("frm-subscr-email-address"), subscription.getEmail());
		}

	}

}
