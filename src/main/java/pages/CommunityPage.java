package pages;

import static com.codeborne.selenide.Selectors.byTestId;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class CommunityPage {

    public final SelenideElement createEventBtn = $(byTestId("community-create-event-link"));

    public MainEventPage clickCreateEventBtn() {
        createEventBtn.click();
        return new MainEventPage();
    }


}
