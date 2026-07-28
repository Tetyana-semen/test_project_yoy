package io.yoy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LoginTests extends BaseTest {

    public static final String SIGN_IN_PICKER_VIEW_TITLE = "Увійти до йой!";

    @BeforeEach
    void openAndSignInYoy() {
        signInPage.open();
        mockRateLimit();
    }

    @Test
    public void shouldLoginSuccessfullyWithValidEmailAndCode() {
        signInPage.signInWithEmailAndCode(testEmail, testCode);
        mainPage.openMePage();
        eventsMePage.verifyUserIsLoggedIn(testEmail);
    }

    @ParameterizedTest
    @CsvSource({
        "tetstEmailgmail.com, Введи справжній email.",
        "testEmail@123, Некоректний формат email."
    })
    public void shouldShowValidationErrorsForInvalidEmailFormats(String email, String expectedMessage) {
        signInPage.enterEmailAndSubmit(email);
        signInPage.verifyEmailValidationErrorMessage(expectedMessage);
    }

    @Test
    public void shouldAllowChangingEmailDuringSignIn() {
        signInPage.enterEmailAndSubmit(testEmail);
        signInPage.clickChangeEmailButton();
        signInPage.verifyUserOnSignInPage(SIGN_IN_PICKER_VIEW_TITLE);
    }

}
