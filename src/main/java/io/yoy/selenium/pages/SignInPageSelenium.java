package io.yoy.selenium.pages;

import static io.yoy.selenium.core.Elements.find;

import org.openqa.selenium.By;

public class SignInPageSelenium {

    public final By emailInput = By.cssSelector("#signin-email");
    public final By emailSubmit = By.cssSelector("#signin-otp-submit-label");
    public final By codeInput = By.cssSelector("#signin-code");
    public final By codeSubmit = By.cssSelector("#signin-code-submit");
    public final By mePageBtn = By.cssSelector("a[href='/me']");

    public SignInPageSelenium openMePage() {
        find(mePageBtn).click();
        return this;
    }

    public SignInPageSelenium loginToYoy(String email, String code) {
        find(emailInput).sendKeys(email);
        find(emailSubmit).click();
        find(codeInput).sendKeys(code);
        find(codeSubmit).click();
        return this;
    }

}