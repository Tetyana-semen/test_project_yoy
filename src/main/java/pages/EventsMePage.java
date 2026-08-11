package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTestId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static utils.WaitUtils.waitUntilElementIsReady;

import com.codeborne.selenide.SelenideElement;

public class EventsMePage {

    public final SelenideElement meDisplayName = $(byTestId("me-display-name"));
    public final SelenideElement createNewCommunityBtn = $(byText("Нова спільнота"));

    public EventsMePage verifyUserIsLoggedIn(String expectedText) {
        meDisplayName.shouldHave(text(expectedText));
        return this;
    }

    public CreateCommunityPage clickCreateNewCommunityButton() {
        waitUntilElementIsReady(createNewCommunityBtn);
        createNewCommunityBtn.click();
        return new CreateCommunityPage();
    }
}
