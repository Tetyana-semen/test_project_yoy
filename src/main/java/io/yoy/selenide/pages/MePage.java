package io.yoy.selenide.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTestId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.yoy.selenide.utils.WaitUtils.waitUntilElementIsReady;

import com.codeborne.selenide.SelenideElement;

public class MePage {

    public final SelenideElement meDisplayName = $(byTestId("me-display-name"));
    public final SelenideElement createNewCommunityBtn = $(byText("Нова спільнота"));
    public SelenideElement communityLink(String text) {
        return $(byText(text));
    }
    public MePage verifyUserIsLoggedIn(String expectedText) {
        meDisplayName.shouldHave(text(expectedText));
        return this;
    }

    public MePage clickCreateNewCommunityButton() {
        waitUntilElementIsReady(createNewCommunityBtn);
        createNewCommunityBtn.click();
        return this;
    }

    public MePage chooseCommunity(String text) {
        waitUntilElementIsReady(communityLink(text));
        communityLink(text).click();
        return this;
    }
}
