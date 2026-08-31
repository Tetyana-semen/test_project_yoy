package io.yoy.selenium.common;

import static io.yoy.selenide.utils.FileUtils.readFromFileNamed;
import static io.yoy.selenium.core.WebDriverProvider.driver;

import io.yoy.selenium.pages.SignInPageSelenium;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.JavascriptExecutor;

public class LoginYoy implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        driver().get("https://test.yoy.events/");

        mockRateLimit();

        new SignInPageSelenium()
            .openMePage()
            .loginToYoy("testEmailYoy@gmail.com", "000000");
    }

    private void mockRateLimit() {
        String js = readFromFileNamed("mock/", "fix_rate_limit.js");
        ((JavascriptExecutor) driver()).executeScript(js);
    }
}
