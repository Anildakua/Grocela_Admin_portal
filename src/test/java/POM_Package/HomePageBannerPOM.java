package POM_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageBannerPOM 
{
	public HomePageBannerPOM(WebDriver driver)
	{
		PageFactory.initElements(driver ,this);
	}

	@FindBy (xpath = "//img[@alt='avatar']")
	WebElement signOut_window;
	
	public void signOut_window()
	{
		signOut_window.click();
	}
	
	@FindBy (xpath = "//a[text()=' Sign Out']")
	WebElement signout_button;
	
	public WebElement signout_button()
	{
		return signout_button;
	}
	
	@FindBy (id = "title")
	WebElement title;
	
	public WebElement title_box()
	{
		return title;
	}
	
	@FindBy (id = "sub_title")
	WebElement sub_title;
	
	public WebElement sub_title_box()
	{
		return sub_title;
	}
	
	@FindBy (id = "is_btn_title")
	WebElement is_btn_title;
	
	public WebElement is_btn_title()
	{
		return is_btn_title;
	}
	
	@FindBy (xpath = "//input[@name='file_path']/../../..")
	WebElement file_path;
	
	public WebElement imaige_file_path()
	{
		return file_path;
	}
	
	@FindBy (xpath = "//button[text()='Save']")
	WebElement Save;
	
	public WebElement Save_button()
	{
		return Save;
	}
	
	@FindBy (xpath = "//span[text()='Product Management']")
	WebElement product_M;
	
	public WebElement productManegement() {
		return product_M;
	}
}
