package avactis_tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import avactis_base.TestBase;
import avactis_pages.ApparelPage;
import avactis_pages.HomePage;
import avactis_pages.IndexPage;

import avactis_pages.ProductPage;
import avactis_pages.SignInPage;

public class ApparelPageTest extends TestBase {
         ApparelPage apparelPage;
         ProductPage productPage;
         SignInPage signInPage;
         HomePage homePage;
         IndexPage indexPage;
         public ApparelPageTest() {
        	 super();
         }
      @Test(priority=1)
          public void apparelPageTitleTest() {
        	 String title= apparelPage.apparelPageTitle();
        	 Assert.assertEquals(title, "Apparel - Avactis Demo Store");
         }
      @Test(priority=2)
         public void clickOnProductTest() {
        	 productPage= apparelPage.selectProduct();
         }
         @BeforeMethod
         public void setUp() {
        	 initialization();
           signInPage=new SignInPage();
       	   signInPage.clickOnSignIn();
       	   homePage=new HomePage();
       	   homePage=signInPage.enterSignDetails();
       	   indexPage=new IndexPage(); 
       	   indexPage=homePage.gotoIndexPage(); 
       	   apparelPage=new ApparelPage(); 
        	apparelPage= indexPage.clickOnApparel();
          }

         @AfterMethod
         public void tearDown() {
        	driver.quit(); 
         }
}
