package com.supermarket.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {

	@DataProvider(name = "loginData")
	public Object[][] getData() {
		return new Object[][] { new Object[] { "user1", "password1" }, new Object[] { "user2", "password2" }, };
	}

}
