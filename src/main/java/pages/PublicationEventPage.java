package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class PublicationEventPage {
    public final SelenideElement nextBtn = $("div > button[type=submit]");
    public PublicationEventPage clickNextBtn() {
        nextBtn.click();
        return this;
    }

}
