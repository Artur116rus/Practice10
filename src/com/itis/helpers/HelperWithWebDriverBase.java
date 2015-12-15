package com.itis.helpers;

import java.util.NoSuchElementException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelperWithWebDriverBase {
	protected final ApplicationManager manager;
	private WebDriver driver;
	private boolean acceptNextAlert = true;

	public HelperWithWebDriverBase(ApplicationManager manager) {
		this.manager = manager;
		driver = manager.getWebDriverHelper().getDriver();
	}

	protected void type(By locator, String property) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(property);
	}

	protected void check (By locator) {
		driver.findElement(locator).click();
	}
	
	protected void selectFromList(String locator, String bday) {
		new Select(driver.findElement(By.name(locator)))
				.selectByVisibleText(bday);
	}

	protected boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	protected boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	protected String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	protected WebElement findElement(By linkText) {
		return driver.findElement(linkText);
	}

	protected void openUrl(String string) {
		driver.get(string);
	}

	protected void click(By linkText) {
		findElement(linkText).click();
	}
}
