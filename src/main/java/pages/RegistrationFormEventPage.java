package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class RegistrationFormEventPage {

    public final SelenideElement nextBtn = $("div > button[type=submit]");

    public RegistrationFormEventPage clickNextBtn() {
        nextBtn.click();
        return this;
    }

}
