package avactis_tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import avactis_base.TestBase;
import avactis_pages.HomePage;
import avactis_pages.SignInPage;

public class SignInPageTest extends TestBase{
       SignInPage signInPage;
       HomePage homePage;
       public SignInPageTest() {
    	   super();
       }
       
       @Test(priority=1)
       public void validatePageTitleTest() {
    	   String title=signInPage.validatePageTitle();
    	   Assert.assertEquals(title, "Avactis Demo Store");
       }
       @Test(priority=2)
	   public void enterDetailsTest() {
		   homePage=signInPage.enterSignDetails();
	   }
      
       @BeforeMethod
       public void setUp() {
    	   initialization();
    	   signInPage=new SignInPage();
    	   signInPage.clickOnSignIn();
    	   
       }
       @AfterMethod
       public void tearDown() {
    	   driver.close();
       }
}
