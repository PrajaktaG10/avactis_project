package avactis_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import avactis_base.TestBase;

public class SignInPage extends TestBase{
    @FindBy(xpath="/html/body/div[1]/div/div/div[2]/div/ul/li[1]/span/a")
    WebElement signin;
	@FindBy(id="account_sign_in_form_email_id")
    WebElement email;
	@FindBy(id="account_sign_in_form_passwd_id")
	WebElement password;
	@FindBy(xpath="//input[@class='btn btn-primary input_submit']")
	WebElement sign_in;
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement register;
	@FindBy(xpath="//input[@name='remember_me']")
	WebElement keep_me_signed_in;
	
	public SignInPage() {
	   PageFactory.initElements(driver, this);
	}
	public void clickOnSignIn() {
		signin.click();
	}
	public String validatePageTitle() {
		return driver.getTitle();
	}
	public HomePage enterSignDetails() {
		email.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		sign_in.click();
		return new HomePage();
	}
	public RegistrationFormPage createNewAccount() {
		register.click();
		return new RegistrationFormPage();
	}
	
}
