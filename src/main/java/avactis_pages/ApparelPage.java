package avactis_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import avactis_base.TestBase;

public class ApparelPage extends TestBase {
    @FindBy(xpath="//form[@id='ProductForm_36']//img[@class='img-responsive']")
    WebElement product;
    
    public ApparelPage() {
    	PageFactory.initElements(driver, this);
    }
    
    public String apparelPageTitle() {
    	return driver.getTitle();
    }
    public ProductPage selectProduct() {
    	product.click();
    	return new ProductPage();
    }
    
}
