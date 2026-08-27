package io.yoy.selenium.core;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.time.Duration;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

    private final By selector;
    private final WebDriverWait wait;

    public Waits(By selector) {
        this.selector = selector;
        this.wait = new WebDriverWait(WebDriverProvider.driver(), Duration.ofSeconds(10));
        this.wait.ignoring(StaleElementReferenceException.class);
        this.wait.pollingEvery(Duration.ofMillis(100));
    }

    public ElementActions visibility() {
        this.wait.until(visibilityOfElementLocated(selector));
        return new ElementActions(selector);
    }

    public void scrollIntoView() {
        ((JavascriptExecutor) WebDriverProvider.driver())
            .executeScript("arguments[0].scrollIntoView({block: 'center'});",
                this.wait.until(visibilityOfElementLocated(selector)));
    }

    public void isHidden() {
        this.wait.until(invisibilityOfElementLocated(selector));
    }

    public void hasTest(String expectedText) {
        this.wait.until(ExpectedConditions.textToBe(selector, expectedText));
    }

    public void containsText(String expectedText) {
        this.wait.until(ExpectedConditions.textMatches(
            selector, Pattern.compile(
                Pattern.quote(expectedText),
                Pattern.CASE_INSENSITIVE
            )
        ));
    }

}