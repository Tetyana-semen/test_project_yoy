package pages;

import static com.codeborne.selenide.Selectors.byTestId;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class EventPage {

    public final SelenideElement manageEventBtn = $(byTestId("manage-event-btn"));

    public EventPage clickManageEventBtn() {
        manageEventBtn.click();
        return this;
    }


}
