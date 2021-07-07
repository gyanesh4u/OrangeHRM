package com.qa.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.pages.DashBoard;
import com.qa.pages.LoginPage;
import com.qa.pages.VacancyPage;
import com.qa.util.TestUtil;

public class VacancyPageTest {

	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public DashBoard dashBoard;
	public VacancyPage vacancyPage;

	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browser = prop.getProperty("browser");
		driver = basePage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		dashBoard = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		vacancyPage = dashBoard.gotoVacancyPage();
	}

	@DataProvider(name = "getVacancyData")
	public Object[][] getCandidatesTestData()  {
		Object vacancyData[][] = TestUtil.getTestData("vacancy");
		return vacancyData;
	}

	@Test(dataProvider = "getVacancyData")
	public void createVacancyTest(String jobTitle, String vacancyName, String hiringManager, String numberOfPositions,
			String description) {
		vacancyPage.addVacancy(jobTitle, vacancyName, hiringManager, numberOfPositions, description);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}