package TestScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM_Packages.HomePageBannerPOM;
import UtilityPackages.BaseClass;

public class HomePageBannerClass extends BaseClass
{
	@Test
	public void AddHomePageBanner()
	{
		//Verify is in correct page 
		Assert.assertEquals(driver.getCurrentUrl(),"http://admin.unosysdev.com/BannerController","its show not get the home page");
		try 
		{
			home.title_box().sendKeys(excel.inputData("Sheet1", 1, 1));
			home.sub_title_box().sendKeys(excel.inputData("Sheet1", 1, 2));
		} 
		catch (Exception e)
		{
			System.out.println("not get the excel data"+e);
		}
		
		//Select "NO" in the drop down
		Select select=new Select(home.is_btn_title());
		home.is_btn_title().click();
		select.getOptions().getFirst().click();
		
		//Click on the Choose file button
		action.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		action.keyDown(Keys.TAB).keyUp(Keys.TAB).sendKeys(Keys.ENTER).perform();
		
		//Image path created
		try 
		{
			StringSelection filepath = new StringSelection(pro.inputData("imaigePath"));
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		}
		catch (Exception e) 
		{
			System.out.println("Imaige file path not availabl"+e);
		}
		
		// image file uploaded 
		try
		{
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
		}
		catch (AWTException e)
		{
			System.out.println("Imaige not uploaded"+e);
		} 
		catch (InterruptedException e) 
		{
			System.out.println("file upload thread is not working"+e);
		}
		
		//Click the save button and hendel pop-up
		home.Save_button().click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

	}
}
