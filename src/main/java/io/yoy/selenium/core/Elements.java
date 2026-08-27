package io.yoy.selenium.core;

import org.openqa.selenium.By;

public final class Elements {

    public static ElementActions find(By locator) {
        return new ElementActions(locator);
    }

    public static ElementActions find(String locator) {
        By targetLocator = locator.startsWith("/") ? By.xpath(locator) : By.cssSelector(locator);

        return new ElementActions(targetLocator);
    }

    public static ElementsCollectionActions findAll(By locator) {
        return new ElementsCollectionActions(locator);
    }

    public static ElementsCollectionActions findAll(String locator) {
        By targetLocator = locator.startsWith("/") ? By.xpath(locator) : By.cssSelector(locator);
        return new ElementsCollectionActions(targetLocator);
    }

}