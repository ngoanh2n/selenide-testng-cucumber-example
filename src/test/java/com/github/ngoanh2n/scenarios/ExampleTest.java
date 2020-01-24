package com.github.ngoanh2n.scenarios;

import com.github.ngoanh2n.common.BaseTest;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.Test;

/**
 * ExampleTest class
 * <br/>
 *
 * @author ngoanh2n@gmail.com (Ho Huu Ngoan)
 */

@CucumberOptions(
        strict = true,
        glue = {"com.github.ngoanh2n"},
        //tags = {"@LoginSuccess", "@LoginFailure", "@HomeWelcome"},
        plugin = {
                "pretty",
                "summary",
                "html:build/cucumber-reports/cucumber-pretty",
                "json:build/cucumber-reports/CucumberTestReport.json",
                "rerun:build/cucumber-reports/rerun.txt"
        },
        features = {"src/test/resources/com/github/ngoanh2n/features"}
)
public class ExampleTest extends BaseTest {

    @SuppressWarnings({"groupsTestNG"})
    @Test(
            groups = "cucumber",
            dataProvider = "scenarios",
            description = "This test demonstrates how to use Selenide, TestNG, Cucumber...")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws Throwable {
        super.runScenario(pickleWrapper, featureWrapper);
    }
}
