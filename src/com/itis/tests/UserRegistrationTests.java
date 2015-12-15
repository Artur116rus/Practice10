package com.itis.tests;


import java.util.List;

import org.junit.Test;

import com.itis.generator.DataGenerator;
import com.itis.models.BaseModel;
import com.itis.models.User;

public class UserRegistrationTests extends TestBase<User> {
	
	@Test
	public void testRegistrationValidUser() {
		DataGenerator.createTestData(User.class);
		List<BaseModel> users = getFromXml("user", new String[]{ "email", "name", "password", "passwordConfirmation"});
		User validUser = (User) users.get(0);
		app.getModelHelper().createModel(validUser);
	}

}
