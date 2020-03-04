package avactis_tests;

import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import avactis_base.TestBase;
import avactis_pages.ApparelPage;
import avactis_pages.FurniturePage;
import avactis_pages.HomePage;
import avactis_pages.IndexPage;
import avactis_pages.ProductPage;
import avactis_pages.SignInPage;
import avactis_util.TestUtil;

public class ProductPageTest extends TestBase{
	SignInPage signInPage;
    HomePage homePage;
	   IndexPage indexPage;
	   ProductPage productPage;
	   ApparelPage apparelPage;
	   TestUtil testUtil;
	   FurniturePage furniturePage;
	   public ProductPageTest(){
    	   super();
       }
	   @Test(priority=1)
	   public void validatepageTitleTest() {
		   String title=productPage.validatePageTitle();
		   Assert.assertEquals(title, "Avactis T-Shirt - Avactis Demo Store");
	   }
	   @Test(priority=2)
	   public void seletSizeTest() {
		   productPage.selectSize();
	   }
	   @Test(priority=3)
	   public void selectQuantityTest() {
		 productPage.selectQuantity();
	    }
	   @Test(priority=4)
	   public void clickOnadd_to_cartTest() {
		 productPage.clickOnadd_to_cart();
	    }
	   @Test(priority=5)
	   public void selectquantityTest() {
		   furniturePage=new FurniturePage();
		   indexPage.clickOnFurniturePage();
	        furniturePage.selectProduct();
		 productPage.selectquantity();
	    }
	   @Test(priority=6)
	   public void clickOnaddToCartTest() {
		 productPage.clickOnaddToCart();
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
	   }
	   @AfterTest
	   public void tearDown() {
		   driver.quit();
	   }
	 
}
