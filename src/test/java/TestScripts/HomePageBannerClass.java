package TestScripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import POM_Packages.HomePageBannerPOM;
import UtilityPackages.BaseClass;

public class HomePageBannerClass extends BaseClass
{
	@Test
	public void AddHomePageBanner() throws InterruptedException 
	{
		Select select=new Select(home.is_btn_title());
		home.is_btn_title().click();
		select.getOptions().getFirst().click();
		Thread.sleep(2000);
		try 
		{
			home.title_box().sendKeys(excel.inputData("Sheet1", 1, 1));
			home.sub_title_box().sendKeys(excel.inputData("Sheet1", 1, 2));
		} 
		catch (Exception e)
		{
			System.out.println("not get the excel data"+e);
		}
		
		
		wait.until(ExpectedConditions.elementToBeClickable(home.imaige_file_path()));
		home.imaige_file_path().click();
		home.Save_button().click();
		home.imaige_file_path().click();
		//home.imaige_file_path().sendKeys("C:\\Users\\Administrator\\Downloads\\imaige.jpg");
//		Thread.sleep(1000);
//		home.Save_button().click();
		
	}
}
