package POM_Packages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPOM {

	public loginPOM(WebDriver driver) {
		PageFactory.initElements(driver , this);
	}
	
	@FindBy (id = "username" )
	WebElement username;
	
	public WebElement username()
	{
		return username;
	}
	
	@FindBy (id = "password" )
	WebElement password;
	
	public WebElement Password()
	{
		return password;
	}
	
	@FindBy (name = "Login" )
	WebElement login;
	
	public WebElement login_Button()
	{
		return login;
	}
	
	@FindBy (xpath = "//p[text()='Login info is not valid.']")
	WebElement notvalid_text;
	
	public WebElement notvalid_text()
	{
		return notvalid_text;
	}
}
