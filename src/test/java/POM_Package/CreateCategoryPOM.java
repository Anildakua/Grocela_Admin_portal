package POM_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCategoryPOM
{
	public CreateCategoryPOM(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	
	@FindBy (xpath = "//a[text()='Create Category ']")
	WebElement create_C;
	
	public WebElement CreateCategory() 
	{
		return create_C;
	}
	
	@FindBy (xpath = "(//button[@type='button'])[1]")
	WebElement product_vertical;
	
	public WebElement productVertical() 
	{
		return product_vertical;
	}
	
	@FindBy (id = "productCategory")
	WebElement product_C;
	
	public WebElement Category_name() 
	{
		return product_C;
	}
	
	@FindBy (id = "description")
	WebElement description;
	
	public WebElement description() 
	{
		return description;
	}
	
	@FindBy (id = "addCatbtn")
	WebElement addCatbtn;
	
	public WebElement add_button() 
	{
		return addCatbtn;
	}
	
	@FindBy (xpath = "//span[text()='Greens']")
	WebElement greens;
	
	public WebElement Greens() 
	{
		return greens;
	}

}
