package Com.MavenTesting2.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Com.MavenTesting2.Utilities.ReadConfig;

public class BaseClass {
	ReadConfig readConfig=new ReadConfig();
	public String baseUrl=readConfig.getApplicationURL();
	public String username=readConfig.getUsername();
	public String password=readConfig.getPassword();
	public WebDriver driver;
	public static Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
		
	    logger=logger.getLogger("MavenTesting");
	    PropertyConfigurator.configure("log4j.properties");
	    if(br.equals("chrome")) {
	    	System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
		    driver=new ChromeDriver();
	    }
	    else if(br.equals("firefox")) {
	    	System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath());
		    driver=new FirefoxDriver();
	    	
	    }
	    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    driver.get(baseUrl);
	}
@AfterClass
public void tearDown() {
	driver.quit();
}


public void captureScreen(WebDriver driver, String tname) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/SceenShots/" + tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
}
public String randomestring()
{
	String generatedstring=RandomStringUtils.randomAlphabetic(8);
	return(generatedstring);
}

public static String randomeNum() {
	String generatedString2 = RandomStringUtils.randomNumeric(4);
	return (generatedString2);
}


}
 