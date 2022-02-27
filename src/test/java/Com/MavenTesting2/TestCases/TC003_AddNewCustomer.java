package Com.MavenTesting2.TestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Com.MavenTesting2.PageObjects.AddCustomerPage;
import Com.MavenTesting2.PageObjects.LoginPage;

public class TC003_AddNewCustomer extends BaseClass{
	@Test
	public void addNewCustomer() throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("user name provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();
		AddCustomerPage addcust=new AddCustomerPage(driver);
				addcust.clickAddNewCustomer();
		logger.info("Providing the customer details..");
		Thread.sleep(3000);
		
		addcust.custName("Rushi");
		addcust.custgender("male");
		addcust.custdob("11", "11", "1999");
		Thread.sleep(3000);
		addcust.custaddress("India");
		addcust.custcity("BLR");
		addcust.custstate("Karnataka");
		addcust.custpinno("560029");
		addcust.custtelephoneno("7864475451");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		//addcust.custpassword("asjdjj");
		addcust.custsubmit();
		}
		
}

