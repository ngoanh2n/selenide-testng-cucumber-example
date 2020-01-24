package com.github.ngoanh2n.pages;

import com.github.ngoanh2n.common.BasePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

/**
 * LoginPage class
 * <br/>
 *
 * @author ngoanh2n@gmail.com (Ho Huu Ngoan)
 */

public class HomePage extends BasePage {

    public void verifyHomePageWelcomeTitle(String title) {
        $("h2[class='blank-state-welcome-title']").shouldHave(text(title));
    }
}
