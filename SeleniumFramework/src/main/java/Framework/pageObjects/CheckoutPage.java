package Framework.pageObjects;

import Framework.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponents {
    WebDriver driver;
    public CheckoutPage(WebDriver driver){
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css="[placeholder='Select Country']")
    WebElement country;

    @FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
    WebElement selectCountry;

    @FindBy(css="a.action__submit")
    WebElement submit;

    By results = By.cssSelector(".ta-results");

    public void selectCountry(String countryName){
        Actions a= new Actions(driver);
        a.sendKeys(country, countryName).build().perform();
        waitForElementToAppear(results);
        selectCountry.click();
    }
    public ConfirmationPage submitOrder(){
        Actions a= new Actions(driver);
        a.moveToElement(submit).build().perform();
        submit.click();
        return new ConfirmationPage(driver);
    }
}