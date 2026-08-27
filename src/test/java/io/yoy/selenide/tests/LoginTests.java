package io.yoy.selenide.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LoginTests extends BaseTest {

    public static final String SIGN_IN_PICKER_VIEW_TITLE = "Увійти до йой!";

    @BeforeEach
    void openAndSignInYoy() {
        app.signInPage.open();
        mockRateLimit();
    }

    @Test
    public void shouldLoginSuccessfullyWithValidEmailAndCode() {
        app.signInPage.signInWithEmailAndCode(testEmail, testCode);
        app.mainPage.openMePage();
        app.mePage.verifyUserIsLoggedIn(testEmail);
    }

    @ParameterizedTest
    @CsvSource({
        "tetstEmailgmail.com, Введи справжній email.",
        "testEmail@123, Некоректний формат email."
    })
    public void shouldShowValidationErrorsForInvalidEmailFormats(String email, String expectedMessage) {
        app.signInPage.enterEmailAndSubmit(email)
            .verifyEmailValidationErrorMessage(expectedMessage);
    }

    @Test
    public void shouldAllowChangingEmailDuringSignIn() {
        app.signInPage.enterEmailAndSubmit(testEmail)
            .clickChangeEmailButton()
            .verifyUserOnSignInPage(SIGN_IN_PICKER_VIEW_TITLE);
    }

}
