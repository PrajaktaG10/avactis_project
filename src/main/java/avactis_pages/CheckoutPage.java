package avactis_pages;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import avactis_base.TestBase;
public class CheckoutPage extends TestBase{
       @FindBy(name="billingInfo[Firstname]")
	    WebElement first_name;
       @FindBy(name="billingInfo[Lastname]")
        WebElement last_name;
       @FindBy(name="billingInfo[Email]")
        WebElement email_id;
       @FindBy(id="billing-info-input_country_select")
       WebElement country;
       @FindBy(name="billingInfo[Postcode]")
        WebElement zipcode;
       @FindBy(id="billing-info-input_state_menu_select")
        WebElement state;
       @FindBy(name="billingInfo[City]")
        WebElement city;
       @FindBy(name="billingInfo[Phone]")
        WebElement contact_phone;
       @FindBy(name="billingInfo[Streetline1]")
        WebElement address_line1;
       @FindBy(xpath="//input[@id='input_text_empty_id_27450']")
       WebElement address_line2;
       @FindBy(xpath="/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]"
       		+ "/div[1]/form[1]/div[3]/div[1]/div[5]/label[1]/div[1]/span[1]/input[1]")
       List<WebElement> shipping_addr_sameas_billing;
       @FindBy(xpath="//input[@name='paymentModule[method_code]']")
        List<WebElement> billing_options;
       @FindBy(xpath="//a[contains(text(),'Continue Shopping')]")
        WebElement continue_shopping;
       @FindBy(xpath="/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[5]/input[1]")
        WebElement continue_checkout1;
       @FindBy(xpath="//span[contains(@class,'en button_back btn btn-default')]")
        WebElement back1;
       @FindBy(xpath=" //span[@class='en btn btn-default button_back']")
       WebElement back2;
       @FindBy(xpath="/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[6]/input[1]")
       WebElement continue_checkout2;
       @FindBy(xpath="//*[@id=\"checkout_3\"]/div[8]/input")
      WebElement place_order;
       @FindBy(xpath="//*[@id=\"checkout_2\"]/div[5]/div/div[3]/div/div[2]/div[1]/label/input")
       WebElement ground_shipping;
       @FindBy(xpath="/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]"
       		+ "/form[1]/div[5]/div[1]/div[3]/div[1]/div[3]/div[1]/label[1]/input[1]")
       List<WebElement> delivery_on_next_business_day;
       @FindBy(name="shippingModuleAndMethod[method_code]")
       List<WebElement> national_priority_airmail;
       
       
       public CheckoutPage() {
    	   PageFactory.initElements(driver, this);
       }
       
     public void enterCustomerDetails(String First_Name, String Last_Name, String Email, String Country, 
    		 String ZIP_Code, String State, String City, String Address, String Contact_Phone) {
    	 first_name.clear();
    	 first_name.sendKeys(First_Name);
    	 last_name.clear();
    	 last_name.sendKeys(Last_Name);
    	 email_id.clear();
    	 email_id.sendKeys(Email);
    	 Select contry=new Select(country);
    	 contry.selectByVisibleText(Country);
    	 zipcode.clear();
    	 zipcode.sendKeys(ZIP_Code);
    	 Select sTate=new Select(state);
    	 sTate.selectByVisibleText(State);
    	 city.clear();
    	 city.sendKeys(City);
    	 address_line1.clear();
    	 address_line1.sendKeys(Address);
    	 contact_phone.clear();
    	 contact_phone.sendKeys(Contact_Phone);
     }
       
      public void selectCheckboxforSameShAdd() {  
       for(WebElement w:shipping_addr_sameas_billing) {
    	   if(w.isDisplayed()) {
    		   if(w.isEnabled()) {
    			   w.click();
    		   }
    	   }
       }
       
      }
      public ApparelPage clickOnContinueShopping() {
    	  continue_shopping.click();
    	return new ApparelPage();  
      }
      public CheckoutPage clickOnContinueCheckout1() {
    	  continue_checkout1.click();
    	  return new CheckoutPage();
      }
      public void selectBillingOptions() {
    	  for(WebElement w:billing_options) {
       	   if(w.isDisplayed()) {
       		   if(w.isEnabled()) {
       			   w.click();
       		   }
       	   }
          }
      }
      public void select_shipping_method() {
    	  ground_shipping.click();
      }
    	 /* String shipping_method= prop.getProperty("shipping_method");
    	if(shipping_method=="GroundShipping") {
    		for(WebElement w:ground_shipping) {
    			if(w.isDisplayed()) {
    				if(w.isEnabled()) {
    					w.click();
    				}
    			}
    		}
    	}else if(shipping_method=="Delivery on Next Business Day") {
    		for(WebElement w:delivery_on_next_business_day) {
    			if(w.isDisplayed()) {
    				if(w.isEnabled()) {
    					w.click();
    				}
    			}
    		}	
    		}
    		else if(shipping_method=="National Priority Airmail") {
        		for(WebElement w:national_priority_airmail) {
        			if(w.isDisplayed()) {
        				if(w.isEnabled()) {
        					w.click();
        				}
        			}
        		}
    	}*/
      
      public CheckoutPage clickOnBack1() {
    	  back1.click();
    	  return new CheckoutPage();
      }
      public CheckoutPage clickOnContinueCheckout2() {
    	  continue_checkout2.click();
    	  return new CheckoutPage();
      }  
      public void clickOnPlaceOrder() {
    	  place_order.click();
      }       
}

