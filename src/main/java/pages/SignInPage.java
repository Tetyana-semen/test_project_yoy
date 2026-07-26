package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class SignInPage {

    public final SelenideElement emailInput = $("#signin-email");
    public final SelenideElement emailSubmit = $("#signin-otp-submit-label");
    public final SelenideElement codeInput = $("#signin-code");
    public final SelenideElement codeSubmit = $("#signin-code-submit");
    public final SelenideElement changeEmailBtn = $("[data-testid='signin-change-email-btn']");
    public final SelenideElement emailError = $("#signin-email-error");
    public final SelenideElement pickerViewTitle = $("#signin-picker-view h1");

    public void open() {
        Selenide.open("signin");
    }

    public void signInWithEmailAndCode(String email, String code) {
        enterEmailAndSubmit(email);
        codeInput.setValue(code);
        codeSubmit.click();
    }

    public void enterEmailAndSubmit(String email) {
        emailInput.setValue(email);
        emailSubmit.click();
    }

    public void clickChangeEmailButton() {
        changeEmailBtn.click();
    }

    public void verifyEmailValidationErrorMessage(String expectedText) {
        emailError.shouldHave(text(expectedText));
    }

    public void verifyUserOnSignInPage(String expectedText) {
        pickerViewTitle.shouldHave(text(expectedText));
    }

}
