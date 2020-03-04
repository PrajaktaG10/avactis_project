package avactis_tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import avactis_base.TestBase;
import avactis_pages.ApparelPage;
import avactis_pages.CheckoutPage;
import avactis_pages.FurniturePage;
import avactis_pages.HomePage;
import avactis_pages.IndexPage;
import avactis_pages.MyCartPage;
import avactis_pages.ProductPage;
import avactis_pages.SignInPage;
import avactis_util.TestUtil;

public class CheckoutPageTest extends TestBase{
	SignInPage signInPage;
    HomePage homePage;
	   IndexPage indexPage;
	   ProductPage productPage;
	   ApparelPage apparelPage;
	   TestUtil testUtil;
	   MyCartPage myCartPage;
	   CheckoutPage checkoutPage;
	   FurniturePage furniturePage;
	   public CheckoutPageTest() {
		   	  super();
		       }
	   String sheetName="address_Details"; 
	   @DataProvider(name="getTestData")
	   public Object[][] getTestData() throws Exception {
		   testUtil=new TestUtil();
		   Object data[][]= testUtil.getData(sheetName);
		   return data;
	   }
      @Test(priority=1, dataProvider="getTestData")
      public void enterCustomerDetails(String First_Name, String Last_Name, String Email, String Country, 
    		  String ZIP_Code, String State, String City, String Address, String Contact_Phone)  {
    	  checkoutPage.enterCustomerDetails(First_Name, Last_Name, Email, Country, ZIP_Code, State, City, Address, Contact_Phone);
      }
      
	   @Test(priority=2)
      public void selectCheckboxforSameShAddTest() throws InterruptedException {
		   Thread.sleep(1000);
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		  	 js.executeScript("window.scrollBy(0,200)");
    	 checkoutPage.selectCheckboxforSameShAdd();
    	 Thread.sleep(1000);
       }
      @Test(priority=3)
      public void clickOnContinueCheckout1Test() {
    	  checkoutPage.clickOnContinueCheckout1();
       }
    @Test(priority=4)
      public void selectBillingOptionsTest() throws AWTException {
    	  Robot robot=new Robot();
    	  robot.keyPress(KeyEvent.VK_PAGE_UP);
    	  checkoutPage.selectBillingOptions();
       }
    @Test(priority=5)
      public void select_shipping_method_Test() throws InterruptedException {
    	  //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    	Thread.sleep(1000);
    	try {
    	   checkoutPage.select_shipping_method();
      }catch(StaleElementReferenceException ex) {
    	  checkoutPage.select_shipping_method();
      }
    }
     /* @Test(priority=4)
      public void clickOnRememberShippingMethodTest() {
    	  myCartPage.clickOnRememberShippingMethod();
      }*/
       @Test(priority=6)
       public void clickOnContinueCheckout2Test() throws InterruptedException {
    	  Thread.sleep(2000);
    	  checkoutPage.clickOnContinueCheckout2();
       }
      @Test(priority=7)
      public void placeOrderTest() {
    	  try {
    	  JavascriptExecutor js = (JavascriptExecutor) driver;
		  	 js.executeScript("window.scrollBy(0,250)");
    	  checkoutPage.clickOnPlaceOrder();
    	  }catch(StaleElementReferenceException ex) {
    		  JavascriptExecutor js = (JavascriptExecutor) driver;
 		  	 js.executeScript("window.scrollBy(0,250)");
     	  checkoutPage.clickOnPlaceOrder();
    	  }
       }

      @BeforeTest
      public void setup(){
   	   initialization();
   	   testUtil=new TestUtil();
       signInPage=new SignInPage();
  	   signInPage.clickOnSignIn();
  	   homePage=new HomePage();
  	   homePage=signInPage.enterSignDetails();
  	   indexPage=new IndexPage(); 
  	   indexPage=homePage.gotoIndexPage(); 
  	   apparelPage=new ApparelPage(); 
   	   apparelPage= indexPage.clickOnApparel();
  	   productPage=new ProductPage();
       productPage= apparelPage.selectProduct();
       productPage.selectSize();
       productPage.selectQuantity();
       productPage.clickOnadd_to_cart();
       furniturePage=new FurniturePage();
	   indexPage.clickOnFurniturePage();
        furniturePage.selectProduct();
	 productPage.selectquantity();
	 productPage.clickOnaddToCart();
       myCartPage=new MyCartPage();
       myCartPage.clickOnMyCart();
       checkoutPage=myCartPage.clickOnCheckout();
       checkoutPage=new CheckoutPage();
         
   	   }
      @AfterTest
      public void tearDown() {
      	   driver.quit();
      } 
        	 
}
