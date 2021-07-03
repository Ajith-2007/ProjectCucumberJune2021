package org.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.BaseClass;

public class LoginPojo extends BaseClass {
	
	public LoginPojo() {
	PageFactory.initElements(driver, this);
	}

	@FindBy(id= "maa")
	private WebElement txtEmail;
	
	@FindBy(id= "pass")
	private WebElement txtPass;
	
	@FindBy(name= "login")
	private WebElement btnLogin;
	
	@FindBy(name= "logout")
	private WebElement btnLogout;
	
	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
	public WebElement getBtnLogout() {
		return btnLogout;
	} 
}
