package com.github.ngoanh2n.common;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.SelenidePageFactory;

/**
 * BasePage class
 * <br/>
 *
 * @author ngoanh2n
 */

public abstract class BasePage extends SelenidePageFactory {

    // Milliseconds
    protected long minTimeoutToWait = 5 * 1000;

    protected BasePage() {
        this.page(WebDriverRunner.driver(), this);
    }
}
