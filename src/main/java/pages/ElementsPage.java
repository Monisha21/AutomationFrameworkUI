package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.JavascriptUtils;

public class ElementsPage {

    WebDriver driver;
    JavascriptUtils javascriptUtils;

    //1. Constructors
    public ElementsPage(WebDriver driver){
        this.driver = driver;
        javascriptUtils = new JavascriptUtils(driver);

    }

    //2. locators
    private By elementslink = By.xpath("(//div[@class='avatar mx-auto white'])[1]");
    private By textBoxbtn = By.xpath("(//li[@id='item-0'])[1]");
    private By fullNameTxt = By.xpath("//input[@id='userName']");
    private By emailTxt = By.xpath("//input[@id='userEmail']");
    private By currentAddressTxt = By.xpath("//textarea[@id='currentAddress']");
    private By permanantAddressTxt = By.xpath("//textarea[@id='permanentAddress']");
    private By submitBtn = By.xpath("//button[@id='submit']");

    private By checkBoxLink = By.xpath("//span[contains(text(),'Check Box')]/parent::li[@id='item-1']");
    private By homeToggle = By.xpath("(//button[@title='Toggle'])[1]");
    private By homeCheckBox = By.xpath("//label[@for='tree-node-home']/child::span[@class='rct-checkbox']");
    private By desktopToggle = By.xpath("(//button[@title='Toggle'])[2]");
    private By desktopCheckBox = By.xpath("//label[@for='tree-node-desktopHiH']/child::span[@class='rct-checkbox']");
    private By notesCheckBox = By.xpath("//label[@for='tree-node-notes']/child::span[@class='rct-checkbox']");
    private By commandsCheckBox = By.xpath("//label[@for='tree-node-commands']/child::span[@class='rct-checkbox']");
    private By resultSelected = By.xpath("//span[@class='text-success']");

    //3. Business functions
    public void elementsPageNavigation(){
        javascriptUtils.scrollIntoView(driver.findElement(elementslink));
        driver.findElement(elementslink).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void textBoxlink(){
        driver.findElement(textBoxbtn).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(fullNameTxt).sendKeys("Monisha");
        driver.findElement(emailTxt).sendKeys("monisha@abc.com");
        driver.findElement(currentAddressTxt).sendKeys("ABC, 10th street, Newzealand");
        driver.findElement(permanantAddressTxt).sendKeys("XYZ, 10th street, Germany");
        javascriptUtils.scrollIntoView(driver.findElement(submitBtn));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(submitBtn).click();
    }

    public void checkBoxLink(){
        driver.findElement(checkBoxLink).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        javascriptUtils.scrollIntoView(driver.findElement(homeToggle));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(homeToggle).click();
        driver.findElement(desktopToggle).click();
        driver.findElement(notesCheckBox).click();
        driver.findElement(commandsCheckBox).click();
        String selectedCheckbox = driver.findElement(resultSelected).getText();
        System.out.println(selectedCheckbox);
    }

}
