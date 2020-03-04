package avactis_tests;

import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import avactis_base.TestBase;
import avactis_pages.FurniturePage;
import avactis_pages.HomePage;
import avactis_pages.IndexPage;
import avactis_pages.ProductPage;
import avactis_pages.SignInPage;

public class FurniturePageTest extends TestBase {
	ProductPage productPage;
	SignInPage signInPage;
	HomePage homePage;
	IndexPage indexPage;
	FurniturePage furniturePage;

	public FurniturePageTest() {
		super();
	}
      @Test(priority=1)
	public void validatePageTitleTest() {
		String title = furniturePage.validateFurniturePageTitle();
		System.out.println(title);
        Assert.assertEquals(title, "Furniture - Avactis Demo Store");	
      }
      @Test(priority=2)
	public void selectProductTest() {
		furniturePage.selectProduct();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		signInPage = new SignInPage();
		signInPage.clickOnSignIn();
		homePage = new HomePage();
		homePage = signInPage.enterSignDetails();
		indexPage = new IndexPage();
		indexPage = homePage.gotoIndexPage();
		furniturePage = new FurniturePage();
		indexPage.clickOnFurniturePage();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
