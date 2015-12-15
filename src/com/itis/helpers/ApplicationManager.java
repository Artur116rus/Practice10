package com.itis.helpers;

import com.itis.models.Settings;

public class ApplicationManager {
	private static Settings settings;

	//private static ApplicationManager instance;
	private WebDriverHelper webDriverHelper;
	private ModelHelper modelHelper;
	private NavigationHelper navigationHelper;

	public ApplicationManager() {
		settings = new Settings("/settings.xml");
		webDriverHelper = new WebDriverHelper();
		modelHelper = new ModelHelper(this);
		navigationHelper = new NavigationHelper(this);
	}
	
	/*public static ApplicationManager getInstance() {
		if (instance == null) instance = new ApplicationManager();
		return instance;
	}*/
	
	public static Settings getSettings() {
		return settings;
	}

	public void stop() {
		webDriverHelper.stop();
	}

	public WebDriverHelper getWebDriverHelper() {
		return webDriverHelper;
	}

	public ModelHelper getModelHelper() {
		return modelHelper;
	}

	public NavigationHelper getNavigationHelper() {
		return navigationHelper;
	}
}
