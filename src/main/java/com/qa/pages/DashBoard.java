package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;
import com.qa.util.TestUtil;

public class DashBoard extends BasePage {

	@FindBy(xpath = "//img[@alt='OrangeHRM']")
	private WebElement dashBoardHeader;

	@FindBy(xpath = "//b[.='Recruitment']")
	private WebElement recruitmentTab;

	@FindBy(xpath = "//a[.='Candidates']")
	private WebElement candidatesTab;

	@FindBy(xpath = "//b[.='PIM']")
	private WebElement pimTab;

	@FindBy(id = "menu_pim_addEmployee")
	private WebElement addEmployeTab;

	@FindBy(xpath = "//a[.='Vacancies']")
	private WebElement vacancyTab;

	public DashBoard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getDashBoardPageTitle() {
		return driver.getTitle();
	}

	public boolean verifyDashBoardPageHeader() {
		return dashBoardHeader.isDisplayed();
	}

	public CandidatesPage gotoCandidatesPage() {
		TestUtil.mouseHover(driver, recruitmentTab);
		candidatesTab.click();
		return new CandidatesPage(driver);
	}

	public EmployeePage goEmloyeePage() {

//		Actions action = new Actions(driver);
//		action.moveToElement(pimTab).build().perform();
		TestUtil.mouseHover(driver, pimTab);
		addEmployeTab.click();
		return new EmployeePage(driver);
	}

	public VacancyPage gotoVacancyPage() {
		TestUtil.mouseHover(driver, recruitmentTab);
		vacancyTab.click();
		return new VacancyPage(driver);
	}
}
