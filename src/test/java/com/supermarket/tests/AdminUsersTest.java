package com.supermarket.tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.supermarket.constants.Constants;
import com.supermarket.extendreports.TestListener;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.HomePage;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.WaitUtility;

public class AdminUsersTest extends BaseClass {

	ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

	LoginPage lpLObj;
	HomePage hpObj;
	AdminUsersPage auObj;
	String sheetName = "AdminUsers";
	WaitUtility wuObj = new WaitUtility();

	@Test(priority = 1, enabled = true, description = "This test case will verify the functionality - Add New Admin User")
	public void newAdminUserDetails() throws InterruptedException, AWTException, IOException {

		lpLObj = new LoginPage(driver);
		hpObj = new HomePage(driver);
		auObj = new AdminUsersPage(driver);
		lpLObj.login(ExcelUtility.readStringData("Login", 1, 0), ExcelUtility.readStringData("Login", 1, 1));
		hpObj.navigateToAdminUsersPage();
		auObj.clickNewBtn();
		auObj.enterUserName(ExcelUtility.readStringData(sheetName, 1, 2));
		auObj.enterPassword(ExcelUtility.readStringData(sheetName, 2, 2));
		auObj.selectUserType(ExcelUtility.readStringData(sheetName, 3, 2));
		auObj.clickSaveBtn();
		boolean actualAddAdminUserSuccessMsg = auObj.isSuccessMsgDisplayed();

		Assert.assertTrue(actualAddAdminUserSuccessMsg, "Add New Admin User functionality failed!");

	}

	@Test(priority = 2, enabled = true, description = "This test case will verify the functionality - Search Admin User Details")
	public void searchDetails() throws InterruptedException, AWTException, IOException {

		auObj = new AdminUsersPage(driver);
		auObj.clickSearchBtn();
		auObj.enterUserNameInSearchWindow(ExcelUtility.readStringData(sheetName, 4, 2));
		auObj.selectUserTypeInSearchWindow(ExcelUtility.readStringData(sheetName, 5, 2));
		auObj.clickSearchBtnInSearchWindow();

		String searchResult = auObj.getuserNameInSearchResult();

		if (searchResult.equals(".........RESULT NOT FOUND.......")) {
			Assert.assertEquals(searchResult, Constants.searchAdminUserUnsuccessfulMsg,
					"Search Admin User Details failed!");
		}

		else {
			Assert.assertEquals(searchResult, ExcelUtility.readStringData(sheetName, 4, 2),
					"Search Admin User Details failed!");

		}

	}

	@Test(priority = 3, enabled = true, description = "This test case will verify the functionality - Reset Admin User Search Details")
	public void resetSearchDetails() throws InterruptedException, AWTException, IOException {
		auObj = new AdminUsersPage(driver);
		auObj.clickSearchBtn();
		auObj.enterUserNameInSearchWindow(ExcelUtility.readStringData(sheetName, 6, 2));
		auObj.selectUserTypeInSearchWindow(ExcelUtility.readStringData(sheetName, 7, 2));
		auObj.clickSearchBtnInSearchWindow();
		auObj.clickResetBtn();
		String actualAdminUsersTableHeading = auObj.getTitleOfTable();

		Assert.assertEquals(actualAdminUsersTableHeading, Constants.expectedAdminUsersTableHeading,
				"Reset functionality of Search Admin User failed!");

	}

}
