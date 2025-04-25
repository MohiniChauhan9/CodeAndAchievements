package Framework.pageObjects;

import Framework.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponents {
    WebDriver driver;
    public CartPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".cartSection h3")
    List<WebElement> cartProducts;

    @FindBy(css=".totalRow button")
    WebElement checkoutBtn;

    public Boolean verifyProductDisplay(String productName){
        Boolean match = cartProducts.stream().anyMatch(Product->Product.getText().equalsIgnoreCase(productName));
        return match;
    }
    public CheckoutPage gotToCheckout(){
        checkoutBtn.click();
        return new CheckoutPage(driver);
    }
}
