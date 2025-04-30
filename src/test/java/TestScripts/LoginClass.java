package TestScripts;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM_Packages.loginPOM;
import UtilityPackages.BaseClass;

public class LoginClass extends BaseClass  {

	@Test
	public void nagetive() throws Exception 
	{
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(login.login_Button()));
		login.username();
		login.Password();
		login.login_Button().click();
		login.username().sendKeys("987654321");
		login.Password().sendKeys("admin321");
		login.login_Button().click();
	}
}
