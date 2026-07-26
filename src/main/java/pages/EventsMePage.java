package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static utils.WaitUtils.waitUntilElementIsReady;

import com.codeborne.selenide.SelenideElement;

public class EventsMePage {

    public final SelenideElement meDisplayName = $("[data-testid='me-display-name']");
    public final SelenideElement createNewCommunityBtn = $x("//*[text()='Нова спільнота']");

    public void verifyUserIsLoggedIn(String expectedText) {
        meDisplayName.shouldHave(text(expectedText));
    }

    public void clickCreateNewCommunityButton() {
        waitUntilElementIsReady((createNewCommunityBtn));
        createNewCommunityBtn.click();
    }
}
