package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;
import com.qa.util.TestUtil;

public class VacancyPage extends BasePage {

	@FindBy(id = "btnAdd")
	private WebElement addBtn;

	@FindBy(xpath = "//select[@id='addJobVacancy_jobTitle']")
	private WebElement jobTitle;

	@FindBy(id = "addJobVacancy_name")
	private WebElement vacancyName;

	@FindBy(id = "addJobVacancy_hiringManager")
	private WebElement hiringManager;

	@FindBy(id = "addJobVacancy_noOfPositions")
	private WebElement noOfPosition;

	@FindBy(id = "addJobVacancy_description")
	private WebElement description;

	@FindBy(id = "btnSave")
	private WebElement saveBtn;

	public VacancyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addVacancy(String job, String vacancy, String manager, String position, String desc) {
		addBtn.click();
		TestUtil.listBoxSelect(jobTitle, job);
		jobTitle.sendKeys(job);
		vacancyName.sendKeys(vacancy);
		hiringManager.sendKeys(manager);
		noOfPosition.sendKeys(position);
		description.sendKeys(desc);
		saveBtn.click();
	}
}
