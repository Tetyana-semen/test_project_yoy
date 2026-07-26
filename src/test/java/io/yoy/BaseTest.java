package io.yoy;


import static com.codeborne.selenide.Selenide.executeJavaScript;
import static utils.FileUtils.readFromFileNamed;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.CreateCommunityPage;
import pages.EventsMePage;
import pages.MainPage;
import pages.SignInPage;

@ExtendWith(ScreenShooterExtension.class)
public class BaseTest {

    protected final SignInPage signInPage = new SignInPage();
    protected final MainPage mainPage = new MainPage();
    protected final EventsMePage eventsMePage = new EventsMePage();
    protected final CreateCommunityPage createCommunityPage = new CreateCommunityPage();

    String testEmail = env.get("TEST_EMAIL");
    String testCode = env.get("TEST_CODE");

    public static Dotenv env = Dotenv.load();

    static {
        Configuration.baseUrl = env.get("BASE_URL");
    }

    public void mockRateLimit() {
        String js = readFromFileNamed("mock/", "fix_rate_limit.js");
        executeJavaScript(js);
    }

}
