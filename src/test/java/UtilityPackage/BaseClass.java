package UtilityPackage;

import java.awt.Robot;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import POM_Package.HomePageBannerPOM;
import POM_Package.loginPOM;
import TestScripts.LoginClass;

public class BaseClass {

	public static WebDriver driver;
	public propartiesClass pro;
	public loginPOM login;
	public WebDriverWait wait;
	public HomePageBannerPOM home;
	public ExcelUtils excel;
	public Actions action;
	public static Logger log;
	
	
	public void test() 
	{
		driver =new ChromeDriver();
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		pro=new propartiesClass();
		login =new loginPOM(driver);
		home =new HomePageBannerPOM(driver);
		excel=new ExcelUtils();
		action=new Actions(driver);
	}
	
	@BeforeClass
	public void beforeClass() 
	{
		test();
		log=LogManager.getLogger(this.getClass());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try
		{
			driver.get(pro.inputData("URL"));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		//login in to site
		String URL="http://admin.unosysdev.com/";
		String Currnt_URL = driver.getCurrentUrl();
		
		if (URL.equals(Currnt_URL))
		{
			try 
			{
				login.username().sendKeys(pro.inputData("username"));
				login.Password().sendKeys(pro.inputData("password"));
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
	
			login.login_Button().click();
			wait.until(ExpectedConditions.urlMatches("http://admin.unosysdev.com/BannerController"));
			
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
		//logout form the application
		home.signOut_window();
		home.signout_button().click();
		driver.quit();
	}
}
