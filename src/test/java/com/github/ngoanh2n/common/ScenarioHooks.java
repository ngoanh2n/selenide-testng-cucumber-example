package com.github.ngoanh2n.common;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * ScenarioHooks class
 * <br/>
 *
 * @author ngoanh2n@gmail.com (Ho Huu Ngoan)
 */

public class ScenarioHooks {

    /*
     * This unit of code will be executed before every scenario (Any tag, includes empty)
     *
     * */
    @Before
    public void openBrowser() {
        Selenide.open();
    }

    /*
     * This unit of code will be executed after every scenario where attached tag @LoginSuccess || @HomeWelcome
     *
     * */
    @After(value = "@LoginSuccess or @HomeWelcome")
    public void logout() {
        SelenideElement profileDropdown = $("a[href='/anonymous.automation']");
        profileDropdown.click();
        // Wait until DropDown show
        profileDropdown.waitUntil(visible, 5 * 1000);
        $("a[href='/users/sign_out']").click();
    }
}
