package avactis_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import avactis_base.TestBase;

public class IndexPage extends TestBase {
    //Page factory
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]")
    WebElement apparel;
	@FindBy(xpath="//a[@class='site-logo']")
	WebElement avactisLogo;
	@FindBy(xpath="//a[@class='dropdown-toggle'][contains(text(),'DVD')]")
	WebElement dvd;
	@FindBy(xpath="//a[@class='dropdown-toggle'][contains(text(),'Computers')]")
	WebElement computers;
	@FindBy(xpath="//div[@class='header-navigation']//a[contains(text(),'Sport')]")
	WebElement sport;
	@FindBy(xpath="//div[@class='header-navigation']//a[contains(text(),'Furniture')]")
	WebElement furniture;
	@FindBy(xpath="//div[@class='header-navigation']//a[contains(text(),'Digital Distribution')]")
	WebElement digital_distribution;
	//Initializing page objects
	public IndexPage(){
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validateIndexPageTitle() {
		return driver.getTitle();
	}
	public boolean validateAvactisImage() {
		return avactisLogo.isDisplayed();
	}
	public ApparelPage clickOnApparel() {
		apparel.click();
		return new ApparelPage();
	}
	public DVDPage clickOnDVDPage() {
		dvd.click();
		return new DVDPage();
	}
	public SportPage clickOnSportPage() {
		sport.click();
		return new SportPage();
	}
	public FurniturePage clickOnFurniturePage() {
		furniture.click();
		return new FurniturePage();
	}
	public ComputersPage clickOnComputersPage() {
		computers.click();
		return new ComputersPage();
	}
	public DigitalDistributionPage clickOnDigitalDistributionPage() {
		digital_distribution.click();
		return new DigitalDistributionPage();
	}
	
}
