package UtilityPackages;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import POM_Packages.loginPOM;
import TestScripts.LoginClass;

public class BaseClass {

	public WebDriver driver;
	public loginPOM login;
	public WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@BeforeClass
	public void beforeClass() 
	{
		propartiesClass pro=new propartiesClass();
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try
		{
			driver.get(pro.inputData("URL"));
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//login in to site
		login =new loginPOM(driver);
		String URL="http://admin.unosysdev.com/";
		String Currnt_URL = driver.getCurrentUrl();
		
		System.out.println(Currnt_URL);
		if (URL.equals(Currnt_URL))
		{
			try 
			{
				login.username().sendKeys(pro.inputData("username"));
				login.Password().sendKeys(pro.inputData("password"));
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			login.login_Button().click();
			String str = driver.getTitle();
			System.out.println(str);
			wait.until(ExpectedConditions.titleContains("http://admin.unosysdev.com/BannerController"));
		}
		else
		{
			Assert.fail("it is not correct page ");
		}
	}
	
	@BeforeMethod
	public void beforeMethod() 
	{
		
	}
	
	@AfterMethod
	public void afterMethod() 
	{
		
	}
	
	@AfterClass
	public void afterClass() 
	{
		driver.quit();
	}
}
