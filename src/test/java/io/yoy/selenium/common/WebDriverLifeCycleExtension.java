package io.yoy.selenium.common;

import io.yoy.selenium.core.WebDriverProvider;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class WebDriverLifeCycleExtension implements BeforeAllCallback, AfterAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        WebDriverProvider.driver();
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) {
        WebDriverProvider.quitDriver();
    }

}
