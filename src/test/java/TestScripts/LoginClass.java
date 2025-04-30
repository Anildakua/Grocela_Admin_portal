package TestScripts;


import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM_Packages.loginPOM;
import UtilityPackages.BaseClass;

public class LoginClass extends BaseClass  {

	@Test (priority = 0)
	public void nagetive() throws Exception
	{
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(login.login_Button()));
		
		//Empty user name and password 
		login.username();
		login.Password();
		login.login_Button().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//invalid  user name and password
		login.username().sendKeys("987654321");
		login.Password().sendKeys("admin321");
		login.login_Button().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test (priority = 1,dependsOnMethods = "nagetive")
	public void positive()
	{
		try {
			//valid user name and password
			login.username().sendKeys(pro.inputData("username"));
			login.Password().sendKeys(pro.inputData("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		login.login_Button().click();
		wait.until(ExpectedConditions.urlMatches("http://admin.unosysdev.com/BannerController"));
	}
}
