package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class CandidatesPage extends BasePage {

	@FindBy(id = "btnAdd")
	private WebElement addBtn;

	@FindBy(id = "addCandidate_firstName")
	private WebElement firstName;

	@FindBy(id = "addCandidate_lastName")
	private WebElement lastName;

	@FindBy(id = "addCandidate_email")
	private WebElement email;

	@FindBy(id = "btnSave")
	private WebElement saveBtn;

	public CandidatesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addCandidate(String fName, String lName, String emailId) {

		addBtn.click();
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		email.sendKeys(emailId);
		saveBtn.click();
	}

}
