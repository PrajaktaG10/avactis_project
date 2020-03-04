package avactis_pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import avactis_base.TestBase;

public class ProductPage extends TestBase{
	@FindBy(xpath="//select[@name='po[22]']")
	WebElement size;
	@FindBy(xpath="//select[@name='quantity_in_cart']")
	WebElement quantity;
	@FindBy(xpath="//input[@class='en btn btn-primary button_add_to_cart input_submit']")
	WebElement add_to_cart;
	@FindBy(xpath="//input[@class='en add_to_wishlist btn btn-default']")
	WebElement add_to_wishlist;
	@FindBy(xpath="//select[@name='quantity_in_cart']")
	WebElement selectquantity;
	@FindBy(xpath="/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"
			+ "/form[1]/div[3]/div[5]/input[1]")
	WebElement addToCart;
     public ProductPage(){
    	 PageFactory.initElements(driver, this);
     }
     public String validatePageTitle() {
    	return driver.getTitle();
     }
     public void selectSize(){
    	 Select Size=new Select(size);
    	 List<WebElement> sizes=Size.getOptions();
    	 Size.selectByVisibleText("M");
     }
     public void selectQuantity(){
    	 Select quntity=new Select(quantity);
    	 List<WebElement> quantities=quntity.getOptions();
    	 quntity.selectByVisibleText("1");
     }
     public void clickOnadd_to_cart() {
    	 add_to_cart.click();
     }
     public void clickOnadd_to_wishlist() {
    	 add_to_wishlist.click();
     }
     public void selectquantity(){
    	 Select quntity=new Select(selectquantity);
    	 List<WebElement> quantities=quntity.getOptions();
    	 quntity.selectByVisibleText("1");
     }
     public void clickOnaddToCart() {
    	 addToCart.click();
     }
     
}
