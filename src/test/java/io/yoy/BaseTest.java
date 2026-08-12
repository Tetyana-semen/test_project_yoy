package io.yoy;


import static com.codeborne.selenide.Selenide.executeJavaScript;
import static utils.FileUtils.readFromFileNamed;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import com.codeborne.selenide.junit5.TextReportExtension;
import io.github.cdimascio.dotenv.Dotenv;
import io.yoy.common.Application;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ScreenShooterExtension.class)
@ExtendWith({TextReportExtension.class})
public class BaseTest {

    public static Dotenv env = Dotenv.load();

    static {
        Configuration.baseUrl = env.get("BASE_URL");
        System.setProperty("selenide.test-id.attribute", "data-testid");
    }

    public static Application app = new Application();

    String testEmail = env.get("TEST_EMAIL");
    String testCode = env.get("TEST_CODE");
    String testPhone = env.get("TEST_PHONE");

    public void mockRateLimit() {
        String js = readFromFileNamed("mock/", "fix_rate_limit.js");
        executeJavaScript(js);
    }

}
