package avactis_tests;

import org.testng.annotations.Test;

import avactis_base.TestBase;
import avactis_pages.ApparelPage;
import avactis_pages.FurniturePage;
import avactis_pages.HomePage;
import avactis_pages.IndexPage;
import avactis_pages.SignInPage;

//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
;

public class IndexPageTest extends TestBase {
	IndexPage indexPage;
    SignInPage signInPage;
    HomePage homePage;
	ApparelPage apparelPage;
	FurniturePage furniturePage;
     public IndexPageTest() {
    	 super();
     }
  @Test(priority=1)
  public void indexPageTitleTest() {
 	 String title= indexPage.validateIndexPageTitle();
 	 Assert.assertEquals(title, "Avactis Demo Store", "Index page title not matched");
  }
  @Test(priority=2)
  public void avactisLogoImageTest() {
 	 boolean flag=indexPage.validateAvactisImage(); 
 	 Assert.assertTrue(flag);
  }
  @Test(priority=3)
  public void clickOnApparelTest() {
 	 apparelPage= indexPage.clickOnApparel(); 
  }
  @Test(priority=4)
  public void clickOnFurnitureTest() {
 	 furniturePage= indexPage.clickOnFurniturePage(); 
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
  }

  @AfterMethod
  public void tearDown() {
 	driver.quit(); 
  }
}
