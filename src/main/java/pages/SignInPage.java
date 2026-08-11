package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class SignInPage {

    public final SelenideElement emailInput = $(byId("signin-email"));
    public final SelenideElement emailSubmit = $(byId("signin-otp-submit-label"));
    public final SelenideElement codeInput = $(byId("signin-code"));
    public final SelenideElement codeSubmit = $(byId("signin-code-submit"));
    public final SelenideElement changeEmailBtn = $(byId("signin-change-email-btn"));
    public final SelenideElement emailError = $(byId("signin-email-error"));
    public final SelenideElement pickerViewTitle = $("#signin-picker-view h1");

    public SignInPage open() {
        Selenide.open("signin");
        return this;
    }

    public MainPage signInWithEmailAndCode(String email, String code) {
        enterEmailAndSubmit(email);
        codeInput.setValue(code);
        codeSubmit.click();
        return new MainPage();
    }

    public SignInPage enterEmailAndSubmit(String email) {
        emailInput.setValue(email);
        emailSubmit.click();
        return this;
    }

    public SignInPage clickChangeEmailButton() {
        changeEmailBtn.click();
        return this;
    }

    public SignInPage verifyEmailValidationErrorMessage(String expectedText) {
        emailError.shouldHave(text(expectedText));
        return this;
    }

    public SignInPage verifyUserOnSignInPage(String expectedText) {
        pickerViewTitle.shouldHave(text(expectedText));
        return this;
    }


}
