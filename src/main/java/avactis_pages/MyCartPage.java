package avactis_pages;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import avactis_base.TestBase;

public class MyCartPage extends TestBase{
      @FindBy(xpath="//a[contains(text(),'My cart')]")
      WebElement mycart;
      @FindBy(xpath="//div[@class='form-group']//a[@class='btn btn-primary'][contains(text(),'Checkout')]")
      WebElement checkout;
      @FindBy(xpath="//a[contains(text(),'Continue Shopping')]")
      WebElement continue_shopping;
      @FindBy(xpath="//input[@class='en btn button_remember input_submit']")
      WebElement remember;
      
      public MyCartPage(){
    	 PageFactory.initElements(driver, this); 
      }
      public String validatePageTitle() {
    	  return driver.getTitle();
      }
      public void clickOnMyCart(){
    	  mycart.click();
      }
      public ApparelPage clickOnContinueShopping() {
    	  continue_shopping.click();
    	  return new ApparelPage();
      }
     
      
      public void clickOnRememberShippingMethod() {
			remember.click();
		} 
     public CheckoutPage clickOnCheckout() {
	  checkout.click();
	  return new CheckoutPage();
     }


}


