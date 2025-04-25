package Framework;

import Framework.pageObjects.CartPage;
import Framework.pageObjects.OrdersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponents {
    WebDriver driver;
    public AbstractComponents(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(css="[routerlink*='cart']")
    WebElement cartHeader;
    @FindBy(css="[routerlink*='myorders']")
    WebElement orderHeader;

    public void waitForElementToAppear(By findBy){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
    public void waitForElementToDisappear(WebElement ele){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(ele));
//        Thread.sleep(2000);
    }
    public CartPage goToCartPage(){
        cartHeader.click();
        CartPage cartPage= new CartPage(driver);
        return cartPage;
    }
    public OrdersPage goToOrdersPage(){
        orderHeader.click();
        OrdersPage ordersPage= new OrdersPage(driver);
        return ordersPage;
    }
}
