package TestScripts;

import static org.testng.Assert.fail;

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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import POM_Package.HomePageBannerPOM;
import UtilityPackage.BaseClass;
import UtilityPackage.listnerClass;
@Listeners(listnerClass.class)
public class HomePageBannerClass extends BaseClass
{
	@Test
	public void AddHomePageBanner() throws Exception
	{
		log.info("Starting AddHomePageBanner test");

	    // Verify correct page
	    Assert.assertEquals(driver.getCurrentUrl(), "http://admin.unosysdev.com/BannerController","Home page not loaded");
	    log.info("Navigated to the correct page");

		try 
		{
			home.title_box().sendKeys(excel.inputData("Sheet1", 2, 1));
			home.sub_title_box().sendKeys(excel.inputData("Sheet1", 2, 2));
			log.info("Title and subtitle retrieved from Excel and entered");
        } 
		catch (Exception e) 
		{
            log.error("Failed to retrieve data from Excel");
		}
		
		// Select 'NO' from the drop-down 
        try
        {
            Select select = new Select(home.is_btn_title());
            home.is_btn_title().click();
            select.getOptions().getFirst().click();
            log.info("Drop-down value 'NO' selected successfully");
        } 
        catch (Exception e) 
        {
            log.error("Drop-down selection failed");
        }
        
        
        // Click Choose File button
        try 
        {
            action.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
            action.keyDown(Keys.TAB).keyUp(Keys.TAB).sendKeys(Keys.ENTER).perform();
            log.info("Navigated to Choose File button");
        } 
        catch (Exception e)
        {
            log.error("File selection failed");
        }
        
    	//Image path created
    	try 
    	{
    		StringSelection filepath = new StringSelection(pro.inputData("imaigePath"));
    		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
    	    log.info("Image path copied successfully");
        } 
    	catch (Exception e) 
    	{
            log.error("Image file path not available");
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
		    log.info("Image uploaded successfully");
        } 
		catch (AWTException e) 
		{
            log.error("Image upload failed");
        }
		catch (InterruptedException e) 
		{
            log.error("File upload thread interrupted");
        }
		
		// Click the save button and handle pop-up
	    try
	    {
	        home.Save_button().click();
	        wait.until(ExpectedConditions.alertIsPresent());
	        driver.switchTo().alert().accept();
	        log.info("Save action completed successfully");
	    } 
	    catch (Exception e)
	    {
	        log.error("Error handling save button or alert");
	    }
	}
}


	
	

	
	
	

