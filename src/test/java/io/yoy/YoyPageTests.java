package io.yoy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static utils.DataFaker.generateRandomCommunityName;
import static utils.DataFaker.generateRandomDescription;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class YoyPageTests extends BaseTest {

    String url = env.get("BASE_URL");
    String test_email= env.get("TEST_EMAIL");
    String test_code = env.get("TEST_CODE");

    public static final String SIGN_IN_PICKER_VIEW_TITLE = "Увійти до йой!";

    @BeforeEach
    void openYoy() {
        open(url);
    }

    @Test
    public void shouldLoginSuccessfullyWithValidEmailAndCode() {
        openSignInForm();
        signInWithEmailAndCode(test_email, test_code);
        verifyUserIsLoggedIn(test_email);
    }

    @ParameterizedTest
    @CsvSource({
        "tetstEmailgmail.com, Введи справжній email.",
        "testEmail@123, Некоректний формат email."
    })
    public void shouldShowValidationErrorsForInvalidEmailFormats(String email, String expectedMessage) {
        openSignInForm();
        enterEmailAndSubmit(email);
        verifyEmailValidationErrorMessage(expectedMessage);
    }

    @Test
    public void shouldAllowChangingEmailDuringSignIn() {
        openSignInForm();
        enterEmailAndSubmit(test_email);
        clickChangeEmailButton();
        verifyUserOnLoginPage(SIGN_IN_PICKER_VIEW_TITLE);
    }

    @Test
    public void shouldCreateNewCommunitySuccessfully() {
        String communityName = generateRandomCommunityName();
        String communityDescription = generateRandomDescription();

        openSignInForm();
        signInWithEmailAndCode(test_email, test_code);
        clickCreateNewCommunityButton();
        fillAndSubmitNewCommunityForm(communityName, communityDescription);
        verifyCommunityWithNameIsCreated(communityName);
    }

    private static void verifyCommunityWithNameIsCreated(String communityName) {
        $("[data-testid='community-title']").shouldHave(text(communityName));
    }

    private static void fillAndSubmitNewCommunityForm(String communityName, String communityDescription) {
        $("[data-testid='community-name-input']").setValue(communityName);
        $("[data-testid='community-description-input']").setValue(communityDescription);
        $("[data-testid='community-create-submit']").click();
    }

    private static void clickCreateNewCommunityButton() {
        $x("//*[text()='Нова спільнота']").click();
    }


    private static void verifyEmailValidationErrorMessage(String expectedText) {
        $("#signin-email-error").shouldHave(text(expectedText));
    }

    private static void verifyUserOnLoginPage(String expectedText) {
        $("#signin-picker-view h1").shouldHave(text(expectedText));
    }

    private static void clickChangeEmailButton() {
        $("[data-testid='signin-change-email-btn']").click();
    }

    private static void verifyUserIsLoggedIn(String expectedText) {
        $("[data-testid='me-display-name']").shouldHave(text(expectedText));
    }

    private static void signInWithEmailAndCode(String email, String code) {
        enterEmailAndSubmit(email);
        $("#signin-code").setValue(code);
        $("#signin-code-submit").click();
    }

    private static void enterEmailAndSubmit(String email) {
        $("#signin-email").setValue(email);
        $("#signin-otp-submit-label").click();
    }

    private static void openSignInForm() {
        $("[data-testid='bottom-nav'] div > a:nth-child(5)").click();
    }

}
