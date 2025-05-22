package TestScripts;


import java.time.Duration;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM_Package.loginPOM;
import UtilityPackage.BaseClass;
import UtilityPackage.listnerClass;

@Listeners(listnerClass.class)
public class LoginClass extends BaseClass  {

	@Test (priority = 0)
	public void nagetive() throws Exception
	{
		log.info("Start nagative sinarios");
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(login.login_Button()));
		
		//Empty user name and password 
		log.warn("Attempting login with empty credentials");
		login.username();
		login.Password();
		login.login_Button().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//invalid  user name and password
		log.warn("Attempting login with invalid credentials");
		login.username().sendKeys("987654321");
		login.Password().sendKeys("admin321");
		login.login_Button().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test (priority = 1,dependsOnMethods = "nagetive")
	public void positive()
	{
		try 
		{
			//valid user name and password
			log.info("Starting positive test cases");
			login.username().sendKeys(pro.inputData("username"));
			login.Password().sendKeys(pro.inputData("password"));
		} 
		catch (Exception e)
		{
			 log.error("Exception occurred: ", e);
		}
		
		login.login_Button().click();
		wait.until(ExpectedConditions.urlMatches("http://admin.unosysdev.com/BannerController"));
	}
}
