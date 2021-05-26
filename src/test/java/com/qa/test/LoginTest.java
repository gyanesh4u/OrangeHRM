package com.qa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.pages.LoginPage;

public class LoginTest {

	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);

	}

	@Test(priority = 1)
	public void loginPageTitleTest() {

		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is:" + title);
		Assert.assertEquals(title, "OrangeHRM");
	}

	@Test(priority = 2)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.verifyforgotPasswordLink(), "forgot pwd link is not displayed");
	}

	@Test(priority = 3)
	public void login_correctData_Test() {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
