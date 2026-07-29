package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementUtils {

    public static WebDriver driver;

    //*********************** ELEMENTS *******************************

    public static WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public static List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }


    //*********************** WAIT UTILS *******************************

    public WebElement presenceOfElement(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement visibilityOfElementLocated(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String titleAvailable(String title, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.titleContains(title));
        return driver.getTitle();
    }

    public boolean urlContains(String urlString, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.urlContains(urlString));
    }

    public Alert waitForAlert(int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public String waitGetAlertText(int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }

    public void waitAcceptAlert(int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }

    public void waitForFrameByIdOrName(String frameIDOrName, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIDOrName));
    }

    public void waitForFrameBylocator(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    public void waitForFrameByIndex(int index, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
    }

    public void waitForFrameByWebElement(WebElement  element, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }
    
}
