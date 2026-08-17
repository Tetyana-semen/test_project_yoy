package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class TicketsEventPage {

    public final SelenideElement nextBtn = $("div > button[type=submit]");

    public TicketsEventPage clickNextBtn() {
        nextBtn.click();
        return this;
    }




}
