package com.supermarket.pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.constants.Constants;
import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

public class AdminUsersPage {

	WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	WaitUtility wuObj = new WaitUtility();

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newBtn;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchBtn;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetBtn;

	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateBtn;

	@FindBy(xpath = "//div[@class='card-header']//h4[text()='Admin Users']")
	WebElement adminUsersHeadingText;

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userType;

	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMsg;

	@FindBy(xpath = "//input[@id='un']")
	WebElement userNameInSearchWindow;

	@FindBy(xpath = "//select[@id='ut']")
	WebElement userTypeInSearchWindow;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchBtnInSearchWindow;

	@FindBy(xpath = "//div[@class='card-header']//h4[text()='Admin Users']")
	WebElement titleOfTable;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")
	WebElement userNameInSearchResult;

	public void clickNewBtn() {
		wuObj.waitUntilTheElementIsClickable(searchBtn);
		guObj.clickTheElement(newBtn, driver);
	}

	public void enterUserName(String usernameToEnter) {
		wuObj.waitUntilTheElementIsClickable(username);
		guObj.sendKeysForElement(username, usernameToEnter, driver);
	}

	public void enterPassword(String passwordToEnter) {
		wuObj.waitUntilTheElementIsClickable(password);
		guObj.sendKeysForElement(password, passwordToEnter, driver);
	}

	public void selectUserType(String userTypeToEnter) {
		guObj.selectByVisibleText(userType, userTypeToEnter);

	}

	public void clickSaveBtn() throws AWTException, InterruptedException {
		wuObj.waitUntilTheElementIsClickableFluentWait(saveBtn);
		guObj.clickCommand(saveBtn);
	}

	public void clickSearchBtn() throws AWTException, InterruptedException {
		wuObj.waitUntilTheElementIsClickable(searchBtn);
		guObj.clickCommand(searchBtn);

	}

	public boolean isSuccessMsgDisplayed() {
		wuObj.waitUntilTheElementIsVisible(successMsg);
		String successMsgDisplayed = successMsg.getText();
		if (successMsgDisplayed.contains(Constants.expectedAddNewAdminUserSuccessMsg)) {
			return true;
		}
		return false;
	}

	public void enterUserNameInSearchWindow(String userNameToEnter) {
		wuObj.waitUntilTheElementIsClickable(userNameInSearchWindow);
		guObj.clearCommand(userNameInSearchWindow);
		guObj.sendKeysForElement(userNameInSearchWindow, userNameToEnter, driver);
	}

	public void selectUserTypeInSearchWindow(String userTypeToEnter) {
		guObj.selectByVisibleText(userTypeInSearchWindow, userTypeToEnter);
	}

	public void clickSearchBtnInSearchWindow() throws InterruptedException {
		wuObj.waitUntilTheElementIsClickable(searchBtnInSearchWindow);
		guObj.clickTheElement(searchBtnInSearchWindow, driver);
	}

	public void clickResetBtn() throws AWTException, InterruptedException {
		wuObj.waitUntilTheElementIsClickable(resetBtn);
		guObj.clickCommand(resetBtn);

	}

	public String getTitleOfTable() {
		wuObj.waitUntilTheElementIsVisible(titleOfTable);
		String title = titleOfTable.getText();
		return title;
	}

	public String getuserNameInSearchResult() {
		wuObj.waitUntilTheElementIsVisible(userNameInSearchResult);
		String userName = userNameInSearchResult.getText();
		return userName;
	}

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
