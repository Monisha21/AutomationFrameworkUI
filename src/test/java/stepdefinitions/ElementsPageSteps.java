package stepdefinitions;


import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.zh_cn.假如;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ElementsPage;

public class ElementsPageSteps{

    WebDriver driver = DriverFactory.initializeWebDriver();
    ElementsPage elementsPage = new ElementsPage(driver);
    Logger logger =Logger.getLogger(ElementsPageSteps.class);

    @Given("Provide values in textbox in elements page and submit")
    public void inputTextBox(){
        elementsPage.elementsPageNavigation();
        elementsPage.textBoxlink();
    }

    @Then("verify textbox success message")
    public void validateTextBoxSuccess(){
        logger.info("Provided text box details has been updated successfully");
    }

    @Given("Check and Uncheck nested checkboxes")
    public void inputCheckBox(){
        elementsPage.elementsPageNavigation();
        elementsPage.checkBoxLink();
    }
}
