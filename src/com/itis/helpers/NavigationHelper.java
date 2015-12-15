package com.itis.helpers;

public class NavigationHelper extends HelperWithWebDriverBase {

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public void openMainPage(String additonalUrl) {
		openUrl(ApplicationManager.getSettings().getBaseUrl() + additonalUrl);
	}
	
	public void redirectToMainPage() {
		openUrl(ApplicationManager.getSettings().getBaseUrl());
	}
	
}
