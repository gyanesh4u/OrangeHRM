package com.qa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.pages.DashBoard;
import com.qa.pages.EmployeePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class EmployeeTest {
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public DashBoard dashBoard;
	public EmployeePage employeePage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		dashBoard = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		employeePage = dashBoard.goEmloyeePage();
	}

	@DataProvider(name = "getEmployeeData")
	public Object[][] getEmployeeTestData() {
		Object[][] employeeData = TestUtil.getTestData("employee1");
		return employeeData;

	}

	@Test(dataProvider = "getEmployeeData")
	public void addEmployeeTest(String firstName, String lastName) {

		employeePage.addEmployee(firstName, lastName);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}