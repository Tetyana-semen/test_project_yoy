package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class InteractionsEventPage {

    public final SelenideElement nextBtn = $("div > button[type=submit]");

    public InteractionsEventPage clickNextBtn() {
        nextBtn.click();
        return this;
    }

}
