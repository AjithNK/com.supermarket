package com.supermarket.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreports.TestListener;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.SettingsPage;
import com.supermarket.utilities.ExcelUtility;

public class SettingsTest extends BaseClass {

	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	LoginPage lpObj;
	SettingsPage spObj;

	@Test(priority = 1, enabled = true, description = "This test case will verify the Logout functionality")
	public void logOutFromApplication() throws IOException, InterruptedException {

		lpObj = new LoginPage(driver);
		lpObj.login(ExcelUtility.readStringData("Login", 1, 0), ExcelUtility.readStringData("Login", 1, 1));
		spObj = new SettingsPage(driver);
		spObj.clickLogoutLink();

		String actualSignInText = lpObj.getSignInText();
		Assert.assertEquals(actualSignInText, Constants.expectedSignInText, "Logout functionality failed!");
	}
}
