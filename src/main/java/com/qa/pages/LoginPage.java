package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class LoginPage extends BasePage {

	@FindBy(id = "txtUsername")
	private WebElement loginName;

	@FindBy(id = "txtPassword")
	private WebElement password;

	@FindBy(id = "btnLogin")
	private WebElement loginBtn;

	@FindBy(xpath = "//a[.='Forgot your password?']")
	private WebElement forgotPwdLink;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean verifyforgotPasswordLink() {
		return forgotPwdLink.isDisplayed();
	}

	public DashBoard login(String un, String pwd) {
		loginName.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new DashBoard(driver);
	}
}
