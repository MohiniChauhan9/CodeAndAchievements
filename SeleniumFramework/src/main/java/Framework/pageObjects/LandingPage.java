package Framework.pageObjects;

import Framework.AbstractComponents;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

//locators belonging to landingPage will be added here
//send real "driver" from selenium-standAloneTest file ->here in this file
public class LandingPage extends AbstractComponents {
    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this); //All web elements will be initialized
    }

//    WebElement userEmail= driver.findElement(By.id("userEmail"));
//    PageFactory form will be converted to this in run time and will be assigned to the name given with the help of initElements() method

//PageFactory - this annotation knows about driver as there is a method- initElements which we have to write first
// which will take care of constructing elements using driver object(argument sent in this method)
    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement passwordEle;

    @FindBy(id="login")
    WebElement submit;

    public ProductCatalogue loginApplication(String email, String password){
        userEmail.sendKeys(email);
        passwordEle.sendKeys(password);
        submit.click();
        return new ProductCatalogue(driver);
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client/");
    }
}

//pageobject should only focus on elements and actions not the data
//validations can't go in page object files(Assert.assertTrue() and all)
//page object file should only have the code to perform action and the web elements .it cannot have data

