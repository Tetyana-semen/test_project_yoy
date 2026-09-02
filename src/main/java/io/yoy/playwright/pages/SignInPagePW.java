package io.yoy.playwright.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SignInPagePW {

    private Page page;

    private final Locator emailInput = page.locator("#signin-email");;
    private final Locator emailSubmit = page.locator("#signin-otp-submit-label");;
    private final Locator codeInput = page.locator("#signin-code");
    private final Locator codeSubmit = page.locator("#signin-code-submit");
    private final Locator mePageBtn = page.locator("a[href='/me']");
    private final Locator signOff = page.getByTestId("logout-btn");


    public SignInPagePW(Page page) {
        this.page = page;
    }

    public SignInPagePW openMePage() {
        mePageBtn.click();
        return this;
    }

    public SignInPagePW loginToYoy(String email, String code) {
        emailInput.fill(email);
        emailSubmit.click();
        codeInput.fill(code);
        codeSubmit.click();
        return this;
    }

    public SignInPagePW logOut() {
        signOff.click();
        return this;
    }

    public SignInPagePW switchUser(String email, String code) {
        openMePage();
        logOut();
        openMePage();
        return loginToYoy(email, code);
    }

}
