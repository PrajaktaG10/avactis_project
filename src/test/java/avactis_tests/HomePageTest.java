package avactis_tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import avactis_base.TestBase;
import avactis_pages.HomePage;
import avactis_pages.IndexPage;
import avactis_pages.SignInPage;

public class HomePageTest extends TestBase{
         SignInPage signInPage;
         HomePage homePage;
         IndexPage indexPage;
	
         public HomePageTest() {
        	 super();
         }
         @Test
         public void gotoIndexPageTest() {
        	 indexPage=homePage.gotoIndexPage();
         }
         @BeforeMethod
         public void setUp() {
      	   initialization();
      	 signInPage=new SignInPage();
      	   signInPage.clickOnSignIn();
      	   homePage=new HomePage();
      	   homePage=signInPage.enterSignDetails();
      	  
         }
         @AfterMethod
         public void tearDown() {
      	   driver.close();
         }
}
