package avactis_pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import avactis_base.TestBase;

public class FurniturePage extends TestBase{
@FindBy(xpath="/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/a[1]/div[1]/h3[1]")
WebElement productSelected;

  public FurniturePage() {
	  PageFactory.initElements(driver, this);
  }
  
  public String validateFurniturePageTitle() {
	  return driver.getTitle();
  }
  
  public ProductPage selectProduct() {
	  productSelected.click();
	  return new ProductPage();
  }
  
	
}
