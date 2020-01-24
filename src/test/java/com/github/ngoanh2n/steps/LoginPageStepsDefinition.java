package com.github.ngoanh2n.steps;

import com.github.ngoanh2n.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * LoginPageStepsDefinition class
 * <br/>
 *
 * @author ngoanh2n@gmail.com (Ho Huu Ngoan)
 */

public class LoginPageStepsDefinition {

    private LoginPage loginPage;

    public LoginPageStepsDefinition(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Given("^I open Gitlab page$")
    public void open() throws Throwable {
        this.loginPage.open();
    }

    @When("^I input username with \"([^\"]*)\"$")
    public void inputUser(String value) throws Throwable {
        this.loginPage.inputUsername(value);
    }

    @When("^I input password with \"([^\"]*)\"$")
    public void inputPassword(String value) throws Throwable {
        this.loginPage.inputPassword(value);
    }

    @When("^I click Sign In button$")
    public void clickSignIn() throws Throwable {
        this.loginPage.clickSignIn();
    }

    @Then("^I see alert status is \"([^\"]*)\"$")
    public void checkAlert(String result) throws Throwable {
        if (result.equals("absent")) {
            this.loginPage.verifyLoginSuccess();
        } else {
            this.loginPage.verifyLoginFailure();
        }
    }

    @Given("^I login with account \"([^\"]*)\" / \"([^\"]*)\"$")
    public void login(String username, String password) throws Throwable {
        this.loginPage.login(username, password);
    }
}
