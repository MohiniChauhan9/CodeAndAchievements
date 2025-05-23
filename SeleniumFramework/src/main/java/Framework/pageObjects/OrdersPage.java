package Framework.pageObjects;

import Framework.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrdersPage extends AbstractComponents {
    WebDriver driver;
    public OrdersPage(WebDriver driver){
        super(driver);
        this.driver= driver;
        PageFactory.initElements(driver, this); //All web elements will be initialized
    }

    @FindBy(css="[routerlink*='myorders']")
    WebElement orderHeader;
    @FindBy(css="tr td:nth-child(3")
    List<WebElement> productNames;

    public Boolean verifyOrdersDisplay(String productName){
        Boolean match = productNames.stream().anyMatch(Product->Product.getText().equalsIgnoreCase(productName));
        return match;
    }
}
