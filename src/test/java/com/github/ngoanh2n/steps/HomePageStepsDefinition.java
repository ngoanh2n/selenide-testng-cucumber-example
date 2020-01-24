package com.github.ngoanh2n.steps;

import com.github.ngoanh2n.pages.HomePage;
import io.cucumber.java.en.Then;

/**
 * HomePageStepsDefinition class
 * <br/>
 *
 * @author ngoanh2n@gmail.com (Ho Huu Ngoan)
 */

public class HomePageStepsDefinition {

    private HomePage homePage;

    public HomePageStepsDefinition(HomePage homePage) {
        this.homePage = homePage;
    }

    @Then("^I see welcome title is \"([^\"]*)\"$")
    public void checkWelcomeTitle(String title) throws Throwable {
        this.homePage.verifyHomePageWelcomeTitle(title);
    }
}
