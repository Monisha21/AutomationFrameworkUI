package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class DriverFactory {

    static WebDriver driver;
    static Properties properties;

//    private static final Logger LOGGER = Logger.getLogger(String.valueOf(DriverFactory.class));

    public static WebDriver initializeWebDriver(){
        properties = initializeProperties();
        String browserName = properties.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else {
            System.out.println("Entered browser name is incorrect " + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(properties.getProperty("url"));
        return driver;
    }

    public static Properties initializeProperties(){

        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config/config.properties");
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;

    }
}
