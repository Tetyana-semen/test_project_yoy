package io.yoy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.Test;

public class BasePage {

    @Test
    public void firstTest() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-blink-features=AutomationControlled");
//        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
//        options.setExperimentalOption("useAutomationExtension", false);
//
//        Configuration.browserCapabilities = options;
//        Configuration.browser = "chrome";

        open("https://test.yoy.events/");
        $("body > nav > div > a:nth-child(5)").click();
        $("#signin-email").setValue("semen.tetiana@nltu.lviv.ua");
        $("#signin-otp-submit-label").click();
        $("#signin-code").setValue("000000");
        $("#signin-code-submit").click();

        $("[data-testid='me-display-name']").shouldBe(visible);


        $("[data-testid='community-name-input']").setValue("TestCommunity");
        $("[data-testid='community-slug-input']").setValue("");
        $("[data-testid='community-description-input']").setValue("");


        $("[data-testid='community-cover-upload-btn']").click();

        $("[data-testid='community-create-submit']").setValue("");




    }

}
