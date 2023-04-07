package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

public class ManageOrdersPage {

	WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	WaitUtility wuObj = new WaitUtility();

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[text()='323']//following::td[6]//a[1]")
	WebElement viewBtn;

	@FindBy(xpath = "//a[@class='btn btn-default' and text()=' Back']")
	WebElement backBtn;

	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement orderDetailsHeading;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[text()='323']//following::td[5]/child::span[1]")
	WebElement statusText;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[text()='323']//following::td[5]//a[@class='btn btn-success btn-sm']")
	WebElement changeStatusBtn;

	@FindBy(xpath = "//div[@class='modal-content']//form//div[@class='modal-body']//select[@id='status' and @onchange='show_cancel(323)']")
	WebElement selectUpdate;

	@FindBy(xpath = "//div[@class='modal-content']//form//div[@class='modal-header']//h4//b[contains(text(),'323')]//following::button[text()='×'][1]")
	WebElement closeBtn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[text()='323']//following::td[5]//a[@class='btn btn-primary btn-sm']")
	WebElement changeDeliveryDateBtn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[4]/td[text()='323']//following::a")
	WebElement assignDeliveryBoyBtn;

	@FindBy(xpath = "//select[@id='delivery_boy_id']/following::input[@value='323']")
	WebElement selectDeliveryBoy;

	@FindBy(xpath = "//button[@class='btn btn-info' and @fdprocessedid='2j0clu']")
	WebElement updateBtn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]//td[text()='315']//following::td[6]//a[2]")
	WebElement deleteBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMsg;

	public void clickViewBtn() {
		wuObj.waitUntilTheElementIsClickable(viewBtn);
		guObj.clickCommand(viewBtn);
	}

	public void clickBackBtn() {
		wuObj.waitUntilTheElementIsClickable(backBtn);
		guObj.clickCommand(backBtn);
	}

	public String getOrderDetailsHeading() {
		wuObj.waitUntilTheElementIsVisible(orderDetailsHeading);
		return orderDetailsHeading.getText();
	}

	public String getStatusTextBefore() {
		wuObj.waitUntilTheElementIsVisible(statusText);
		String status = statusText.getText();
		return status;
	}

	public void clickChangeStatusBtn() {
		wuObj.waitUntilTheElementIsClickable(changeStatusBtn);
		guObj.clickCommand(changeStatusBtn);
	}

	public void selectUpdateStausDropdown() {
		guObj.selectByVisibleText(selectUpdate, "Delivered");
	}

	public void clickCloseBtn() {
		wuObj.waitUntilTheElementIsClickableFluentWait(closeBtn);
		guObj.clickCommand(closeBtn);
	}

	public String getStatusTextAfter() {
		wuObj.waitUntilTheElementIsVisible(statusText);
		String status = statusText.getText();
		return status;
	}

	public void clickAssignDeliveryBoyBtn() {
		guObj.scrollToTheElement(assignDeliveryBoyBtn, driver);
		wuObj.waitUntilTheElementIsClickable(assignDeliveryBoyBtn);
		guObj.clickCommand(assignDeliveryBoyBtn);
	}

	public void selectDeliveryBoyDropdown() {
		guObj.selectByVisibleText(selectDeliveryBoy, "sumesh");
	}

	public void clickUpdateBtn() {
		wuObj.waitUntilTheElementIsClickable(updateBtn);
		guObj.clickCommand(updateBtn);
	}

	public void clickDeleteBtn() {
		wuObj.waitUntilTheElementIsClickableFluentWait(changeStatusBtn);
		guObj.clickCommand(deleteBtn);

	}

	public void acceptAlertForDeleting() {
		wuObj.waitUntilTheAlertIsPresent();
		guObj.acceptAlert(driver);

	}

	public String successMsgDisplayed() {
		wuObj.waitUntilTheElementIsVisible(successMsg);
		return successMsg.getText();
	}

	public ManageOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
