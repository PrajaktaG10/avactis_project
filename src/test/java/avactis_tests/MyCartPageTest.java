package avactis_tests;


import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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

public class MyCartPageTest extends TestBase{
	SignInPage signInPage;
    HomePage homePage;
	   IndexPage indexPage;
	   ProductPage productPage;
	   ApparelPage apparelPage;
	   TestUtil testUtil;
	   MyCartPage myCartPage;
	   CheckoutPage checkoutPage;
	   FurniturePage furniturePage;
      public MyCartPageTest() {
    	  super();
      }
      @Test(priority=1)
      public void validatePageTitleTest(){
    	  String title=myCartPage.validatePageTitle();
    	  Assert.assertEquals(title, "Avactis T-Shirt - Avactis Demo Store");
      }
      @Test(priority=2)
      public void clickOnMyCartTest() {   
          myCartPage.clickOnMyCart();
      }
    
      @Test(priority=3)
      public void clickOnCheckoutTest() {
    	  checkoutPage=myCartPage.clickOnCheckout();
      }
      @BeforeTest
     public void setup() {
    	  initialization();
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
	   }
      @AfterTest
	   public void tearDown() {
		   driver.quit();
	   }
}
