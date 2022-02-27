package Com.MavenTesting2.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(name="uid")
	WebElement userName;
	@FindBy(name="password")
	WebElement password;
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	@FindBy(xpath="/html/body/div[3]/div/ul/li[10]/a")
	@CacheLookup
	WebElement lnkLogout;
	public void setUserName(String uname) {
		userName.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void clickSubmit() {
		btnLogin.click();
	}
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
}
