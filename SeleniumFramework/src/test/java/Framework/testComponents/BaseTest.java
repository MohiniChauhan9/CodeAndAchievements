package Framework.testComponents;

import Framework.pageObjects.LandingPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public LandingPage landingPage;
    public WebDriver initializeDriver() throws IOException{
        //properties class
        Properties prop= new Properties();
        FileInputStream fis= new FileInputStream("C:\\Users\\mohini.c.in\\IdeaProjects\\SeleniumFramework\\src\\main\\java\\Framework\\resources\\GlobalData.properties");
        prop.load(fis);
        String browserName=prop.getProperty("browser");

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohini.c.in\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            driver= new ChromeDriver();
        }else if(browserName.equals("firebox")){
            //path of firefox driver file
            System.setProperty("webdriver.firefox.driver", "firefoxdriver.exe");
            driver= new FirefoxDriver();
        }//add for edge also

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException{
        driver= initializeDriver();
        landingPage =new LandingPage(driver);
        landingPage.goTo();
        return landingPage;
    }

    //convert .json file to List of Hashmap
    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        //read .json file to string
        String jsonContent = FileUtils.readFileToString(new File(filePath),
                StandardCharsets.UTF_8);

//        String to HashMap - Jackson Databind
        ObjectMapper mapper= new ObjectMapper();
        List<HashMap<String, String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
        return data;
    }

//    @AfterTest(alwaysRun=true)
//    public void tearDown(){
//        driver.close();
//    }
}


