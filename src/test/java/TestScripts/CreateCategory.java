package TestScripts;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import UtilityPackage.BaseClass;

public class CreateCategory extends BaseClass
{

	@Test
	public void positive() 
	{
		log.info("CreateCategory test case started");
		home.productManegement().click();
		wait.until(ExpectedConditions.visibilityOf(category.CreateCategory())).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://admin.unosysdev.com/ProductManagement","it's not in CreateCategory page");
		
		// Select the vertical
		category.productVertical().click();
		category.Greens().click();
		log.info("Vertical is selected");
		
		//Enter category name and Description
		try
		{
			category.Category_name().sendKeys(excel.inputData("Sheet1", 7, 1));
			category.description().sendKeys(excel.inputData("Sheet1", 8, 1));
			log.info("Title and subtitle retrieved from Excel and entered");
			Thread.sleep(3000);
		} 
		catch (Exception e) 
		{
			log.error("Failed to retrieve data from Excel");
		}

		// Click the add button and handle pop-up
	    try
	    {
	    	category.add_button().click();
	        wait.until(ExpectedConditions.alertIsPresent());
	        driver.switchTo().alert().accept();
	        log.info("Add action completed successfully");
	    } 
	    catch (Exception e)
	    {
	        log.error("Error handling save button or alert");
	    }
	}
	
	@Test
	public void enterProductNameOnly()
	{
		
	}
}
