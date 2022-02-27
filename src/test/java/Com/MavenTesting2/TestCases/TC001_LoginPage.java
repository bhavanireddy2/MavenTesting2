package Com.MavenTesting2.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.MavenTesting2.PageObjects.LoginPage;

public class TC001_LoginPage extends BaseClass{
	@Test
	public void loginTest() throws IOException {
		driver.get(baseUrl);
		logger.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username is entered");
		lp.setPassword(password);
		logger.info("password is entered");
		lp.clickSubmit();
		if(driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("login passed");
		}else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("login failed");
		}
		}
	}


