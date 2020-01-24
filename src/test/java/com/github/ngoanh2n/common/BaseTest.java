package com.github.ngoanh2n.common;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * BaseTest class
 * <br/>
 *
 * @author ngoanh2n@gmail.com (Ho Huu Ngoan)
 */

//@CucumberOptions(
//        strict = true,
//        glue = {"com.github.ngoanh2n"},
//        tags = {"@LoginSuccess", "@LoginFailure", "@HomeWelcome"},
//        plugin = {
//                "pretty",
//                "summary",
//                "html:build/cucumber-reports/cucumber-pretty",
//                "json:build/cucumber-reports/CucumberTestReport.json",
//                "rerun:build/cucumber-reports/rerun.txt"
//        },
//        features = {"src/test/resources/com/github/ngoanh2n/features"}
//)
public abstract class BaseTest extends AbstractTestNGCucumberTests {

    private final static Logger logger = LoggerFactory.getLogger(lookup().lookupClass());
    private final static String selenideProperties = "selenide.properties";

    @BeforeClass
    public void setUpClass() {
        /*
         * Load selenide.properties file in resources
         */
        Properties props = new Properties();
        InputStream inputStream = BaseTest.class
                .getClassLoader()
                .getResourceAsStream(selenideProperties);
        try {
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!props.isEmpty()) {
            for (Object propObj : props.keySet()) {
                String prop = String.valueOf(propObj);

                if (!System.getProperties().containsKey(prop)) {
                    System.setProperty(prop, props.getProperty(prop));
                }
            }
        }

        logger.info("Loading selenide properties as {}", selenideProperties);
        super.setUpClass();
    }

    @AfterClass
    public void tearDownClass() {
        if (WebDriverRunner.hasWebDriverStarted()) WebDriverRunner.closeWebDriver();
        super.tearDownClass();
    }
}
