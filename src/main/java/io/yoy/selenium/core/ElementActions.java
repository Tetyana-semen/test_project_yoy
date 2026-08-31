package io.yoy.selenium.core;

import static io.yoy.selenium.core.WebDriverProvider.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementActions {

    private final By selector;
    private WebElement element;

    public ElementActions(By selector) {
        this.selector = selector;
    }

    public void click() {
        waitFor().visibility();
        driver().findElement(selector).click();
    }

    public void sendKeys(String text) {
        waitFor().visibility();
        driver().findElement(selector).sendKeys(text);
    }

    public Waits waitFor() {
        return new Waits(this.selector);
    }

}
