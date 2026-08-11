package pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class RegistrationFormEventPage {

    public final SelenideElement nextBtn = $("body > div > div.fixed.bottom-0.left-0.right-0.bg-paper.border-t.border-line.z-20 > div > div > div > div > button");

    public RegistrationFormEventPage clickNextBtn() {
        nextBtn.click();
        return this;
    }

}
