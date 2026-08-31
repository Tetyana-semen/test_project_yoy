package io.yoy.selenium.core;

import static io.yoy.selenium.core.WebDriverProvider.driver;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementsCollectionActions {

    private final By selector;

    public ElementsCollectionActions(By selector) {
        this.selector = selector;
    }

    public List<WebElement> elements() {
        return driver().findElements(selector);
    }

    public int size() {
        return elements().size();
    }

    public ElementsCollectionActions shouldHaveSize(int expectedSize) {
        int actualSize = size();
        if (actualSize != expectedSize) {
            throw new AssertionError(
                "Expected " + expectedSize + " elements, but found " + actualSize + " for selector: " + selector
            );
        }
        return this;
    }

}
