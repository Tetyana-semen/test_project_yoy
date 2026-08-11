package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byTestId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class IFramePage {

    public final SelenideElement registerBtn = $("#yoy-root > button");
    public final SelenideElement registerTicketBtn = $("div.yoy-tickets > div > button");
    public final SelenideElement nameInput = $(byId("yoy-f-name"));
    public final SelenideElement lastnameInput = $(byId("yoy-f-lastname"));
    public final SelenideElement emailInput = $(byId("yoy-f-email"));
    public final SelenideElement phoneInput = $(byId("yoy-f-phone"));
    public final SelenideElement register = $(byText("Зареєструватися"));
    public final SelenideElement nameOnRegistrationField = $("div.yoy-done-ticket-event");
    public final SelenideElement embedRegistrationSuccess = $(byTestId("embed-registration-success"));


    public IFramePage clickRegisterBtn(String eventId, String name, String lastname, String email, String phone) {
        Selenide.switchTo().frame(
            $(String.format("iframe[src*='https://embed.test.yoy.events/e/%s']", eventId))
        );registerBtn.click();
        registerTicketBtn.click();
        nameInput.setValue(name);
        lastnameInput.setValue(lastname);
        emailInput.setValue(email);
        phoneInput.setValue(phone);
        register.click();

        return this;
    }

    public IFramePage verifyUserIsRegisteredForCurrentEvent(String name) {
        embedRegistrationSuccess.shouldBe(visible);
        nameOnRegistrationField.shouldHave(text(name));
        return this;
    }





}
