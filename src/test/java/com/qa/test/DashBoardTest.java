package com.qa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.pages.DashBoard;
import com.qa.pages.LoginPage;

public class DashBoardTest {

	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public DashBoard dashBoard;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		dashBoard = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void verifyDashBoardPageTitleTest() {
		String title = dashBoard.getDashBoardPageTitle();
		System.out.println("dashboard title is" + title);
		Assert.assertEquals(title, "OrangeHRM");

	}

	@Test
	public void verifyDashBoardHeaderTest() {
		Assert.assertTrue(dashBoard.verifyDashBoardPageHeader());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
