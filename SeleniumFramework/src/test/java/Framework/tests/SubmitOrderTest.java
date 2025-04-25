package Framework.tests;

import Framework.pageObjects.*;
import Framework.testComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {
    String productName= "QWERTY";

    @Test(dataProvider="getData", groups={"Purchase"})
    public void SubmitOrder(HashMap<String, String> input) throws IOException {
//        WebDriverManager.chromedriver().setup();

        String countryName="india";
        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
        List<WebElement> products= productCatalogue.getProductList();
        productCatalogue.addProductToCart(input.get("product"));
        CartPage cartPage = productCatalogue.goToCartPage();
        boolean match = cartPage.verifyProductDisplay(input.get("product"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.gotToCheckout();
        checkoutPage.selectCountry(countryName);
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String confirmMessage = confirmationPage.getConfirmMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @Test(dependsOnMethods = {"SubmitOrder"})
    public void OrderHistoryTest(){
        ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
        OrdersPage ordersPage= productCatalogue.goToOrdersPage();
        boolean match = ordersPage.verifyOrdersDisplay(productName);
        Assert.assertTrue(match);
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        String filePath="C:\\Users\\mohini.c.in\\IdeaProjects\\SeleniumFramework\\src\\test\\java\\Framework\\data\\PurchaseOrder.json";
        List<HashMap<String, String>> data= getJsonDataToMap(filePath);
        return new Object[][] {{data.get(0)}, {data.get(1)}};
    }

//    @DataProvider
//    public Object[][] getData(){
//        return new Object[][]{{"anshika@gmail.com", "Iamking@000", "QWERTY"},
//                              {"shetty@gmail.com", "Iamking@000", "ZARA COAT 3"}};
//    }

//    @DataProvider
//    public Object[][] getData(){
//        HashMap<String, String> map1= new HashMap<>();
//        map1.put("email","anshika@gmail.com");
//        map1.put("password", "Iamking@000");
//        map1.put("product", "QWERTY");
//        HashMap<String, String> map2= new HashMap<>();
//        map2.put("email","shetty@gmail.com");
//        map2.put("password", "Iamking@000");
//        map2.put("product", "ZARA COAT 3");
//        return new Object[][]{{map1}, {map2}};
//    }
}