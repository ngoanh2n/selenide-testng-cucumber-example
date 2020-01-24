package com.github.ngoanh2n.pages;

import com.codeborne.selenide.Selenide;
import com.github.ngoanh2n.common.BasePage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

/**
 * LoginPage class
 * <br/>
 *
 * @author ngoanh2n@gmail.com (Ho Huu Ngoan)
 */

public class LoginPage extends BasePage {

    public void open() {
        Selenide.open("/users/sign_in");
    }

    public void inputUsername(String username) {
        $("#user_login").setValue(username);
    }

    public void inputPassword(String password) {
        $("#user_password").setValue(password);
    }

    public void clickSignIn() {
        $("input[type='submit'][value='Sign in']").click();
    }

    public void verifyLoginSuccess() {
        $("div[class^='flash-alert']").shouldNot(exist);
    }

    public void verifyLoginFailure() {
        $("div[class^='flash-alert']").should(exist);
    }

    public void login(String username, String password) {
        this.inputUsername(username);
        this.inputPassword(password);
        this.clickSignIn();
    }
}
