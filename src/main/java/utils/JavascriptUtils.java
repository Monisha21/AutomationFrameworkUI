package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtils {

    WebDriver driver;

    public JavascriptUtils(WebDriver driver){
        this.driver = driver;
    }

    //Scroll
    public void scrollIntoView(WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }


}
