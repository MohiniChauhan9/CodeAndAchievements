package Framework.pageObjects;

import Framework.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

//locators belonging to landingPage will be added here
//send real "driver" from selenium-standAloneTest file ->here in this file
public class ProductCatalogue extends AbstractComponents {
    WebDriver driver;
    public ProductCatalogue(WebDriver driver){
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this); //All web elements will be initialized
    }

//    List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
    @FindBy(css=".mb-3")
    List<WebElement> products;

    @FindBy(css=".ng-animating")
    WebElement spinner;

    By productsBy= By.cssSelector(".mb-3");
    By toastMessage= By.cssSelector("#toast-container");
    public List<WebElement> getProductList(){ //action method
        waitForElementToAppear(productsBy);
        return products;
    }
    public WebElement getProductByName(String productName){
        WebElement selectedProduct= getProductList().stream().filter( product->
                product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return selectedProduct;
    }
    public void addProductToCart(String productName){
        WebElement product= getProductByName(productName);
        product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        waitForElementToAppear(toastMessage);
        waitForElementToDisappear(spinner);
//        waitForElementToDisappear();
        goToCartPage();
    }
}


