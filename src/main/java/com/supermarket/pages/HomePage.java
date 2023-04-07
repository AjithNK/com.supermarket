package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtilities;
import com.supermarket.utilities.WaitUtility;

public class HomePage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wuObj = new WaitUtility();

	@FindBy(xpath = "//p[text()='Mobile Slider']/preceding::a[@href='http://groceryapp.uniqassosiates.com/admin/list-mobileslider']")
	WebElement moreInfoMobileSlider;

	@FindBy(xpath = "//a[@href='http://groceryapp.uniqassosiates.com/admin/expense']")
	WebElement moreInfoManageExpense;

	@FindBy(xpath = "//p[text()='Manage Orders']/parent::a")
	WebElement moreInfoManageOrders;

	@FindBy(xpath = "//p[text()='Push Notifications']//parent::a")
	WebElement pushNotificationsLink;

	@FindBy(xpath = "//a[contains(text(),'Home')]/following::li")
	WebElement dashboardTextInHomePageBreadcrum;

	@FindBy(xpath = "//a[@class='small-box-footer' and @href='http://groceryapp.uniqassosiates.com/admin/list-deliveryboy']")
	WebElement moreInfoManageDeliveryBoy;

	@FindBy(xpath = "//a[@class='small-box-footer' and @href='http://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement moreInfoAdminUsers;

	public void navigateToPushNotificationsPage() throws InterruptedException {
		wuObj.waitUntilTheElementIsClickable(pushNotificationsLink);
		gu.clickCommand(pushNotificationsLink);
	}

	public void navigateToMobileSliderPage() {
		wuObj.waitUntilTheElementIsClickable(moreInfoMobileSlider);
		moreInfoMobileSlider.click();
	}

	public void navigateToManageDeliveryBoyPage() throws InterruptedException {
		wuObj.waitUntilTheElementIsClickable(moreInfoManageDeliveryBoy);
		gu.clickCommand(moreInfoManageDeliveryBoy);
	}

	public void navigateToAdminUsersPage() throws InterruptedException {
		wuObj.waitUntilTheElementIsClickable(moreInfoAdminUsers);
		gu.clickCommand(moreInfoAdminUsers);
	}

	public void navigateToManageExpensePage() throws InterruptedException {
		gu.scrollTillBottom(driver);
		wuObj.waitUntilTheElementIsClickable(moreInfoManageExpense);
		gu.clickCommand(moreInfoManageExpense);
	}

	public void navigateToManageOrdersPage() throws InterruptedException {
		wuObj.waitUntilTheElementIsClickable(moreInfoManageOrders);
		gu.clickCommand(moreInfoManageOrders);
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String isDashboardTextDisplayedInHomePageBreadcrum() {
		wuObj.waitUntilTheElementIsVisible(dashboardTextInHomePageBreadcrum);
		String dashboardText = dashboardTextInHomePageBreadcrum.getText();
		return dashboardText;

	}

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
