package io.yoy.playwright.tests;

import static io.yoy.selenide.utils.FileUtils.readFromFileNamed;

import com.microsoft.playwright.Page;
import io.github.cdimascio.dotenv.Dotenv;
import io.yoy.playwright.common.PWApplication;
import org.junit.jupiter.api.BeforeEach;

public class BasePlaywrightTest {

    protected PWApplication app;
    public static Dotenv env = Dotenv.load();

    String testEmail = env.get("TEST_EMAIL");
    String secondTestEmail = env.get("SECOND_TEST_EMAIL");
    String testCode = env.get("TEST_CODE");

    @BeforeEach
    void setUp(Page page) {
        mockRateLimit(page);
        app = new PWApplication(page);
        app.homePage.open();
        app.signInPagePW
            .openMePage()
            .loginToYoy(
                testEmail,
                testCode
            );
    }

    public static void mockRateLimit(Page page) {
        String js = readFromFileNamed("mock/", "fix_rate_limit.js");
        page.addInitScript(js);
    }

}
