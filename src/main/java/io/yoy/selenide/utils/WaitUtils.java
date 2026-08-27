package io.yoy.selenide.utils;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

public class WaitUtils {

    public static void waitUntilElementIsReady(SelenideElement element) {
        element.shouldBe(visible, Duration.ofSeconds(30))
            .shouldBe(enabled, Duration.ofSeconds(20))
            .shouldBe(interactable, Duration.ofSeconds(20))
            .scrollIntoView(true);
    }

}
