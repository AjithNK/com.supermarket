package com.supermarket.utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	WebDriver driver;

	public void implicitWaitSample(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	}

	public void waitUntilTheElementIsVisible(WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(7));
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntilTheElementsAreVisible(List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(7));
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
		
	}

	public void waitUntilTheElementIsLocated(WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(7));
		explicitWait.until(ExpectedConditions.presenceOfElementLocated((By) element));
	}

	public void waitUntilTheAlertIsPresent() {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(7));
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitUntilTheElementIsClickable(WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(7));
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntilTheTitleContains(String text) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(7));
		explicitWait.until(ExpectedConditions.titleContains(text));
	}

	public void waitUntilTheElementIsClickableFluentWait(WebElement element) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);

		wait.until(ExpectedConditions.elementToBeClickable(element)).click();

	}

	public void waitUntilTheElementIsVisibleFluentWait(WebElement element) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);

		wait.until(ExpectedConditions.visibilityOf(element));

	}

}
