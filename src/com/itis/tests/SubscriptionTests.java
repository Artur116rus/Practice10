package com.itis.tests;

import org.junit.Test;

import com.itis.generator.DataGenerator;
import com.itis.models.Subscription;

public class SubscriptionTests extends TestBase<Subscription> {
	
	@Test
	public void testValidSubscription() {
		DataGenerator.createTestData(Subscription.class);
		Subscription subscription = (Subscription) getFromXml("subscription", new String[]{"email"}).get(0);
		app.getModelHelper().createModel(subscription);
	}	

}
