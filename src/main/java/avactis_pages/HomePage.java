package avactis_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import avactis_base.TestBase;

public class HomePage extends TestBase{
  @FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/a[1]")
  WebElement logo;
  
  public HomePage() {
	  PageFactory.initElements(driver, this);
  }
  public IndexPage gotoIndexPage() {
	  logo.click();
	  return new IndexPage();
  }

}
