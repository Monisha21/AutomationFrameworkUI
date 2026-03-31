package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features", //the path of the feature files
        glue={"stepdefinitions"}, //the path of the step definition files
//        format= {"pretty","html:test-output", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting
        monochrome = true, //display the console output in a proper readable format
//        strict = false, //it will check if any step is not defined in step definition file
        dryRun = false, //to check the mapping is proper between feature file and step def file
        tags = "@ElementsCheckBox"
)


public class TestRunner {


}
