package io.yoy;

import static com.codeborne.selenide.Selenide.open;
import static utils.CommunityData.generateRandom;
import static utils.DataFaker.generateRandomDescription;
import static utils.DataFaker.generateRandomString;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.CreateWidgetPage;

public class WidgetPageTest extends BaseTest {
    private static HttpServer server;
    private static URI pageUri;

    @BeforeAll
    static void startServer() throws IOException {

        Path outputDirectory = Path.of("outputs").toAbsolutePath();

        Files.createDirectories(outputDirectory);

        server = SimpleFileServer.createFileServer(
            new InetSocketAddress("127.0.0.1", 0),
            outputDirectory,
            SimpleFileServer.OutputLevel.NONE
        );

        server.start();

        pageUri = URI.create(
            "http://127.0.0.1:"
                + server.getAddress().getPort()
                + "/embed-widget-landing.html"
        );
    }

    @AfterAll
    static void stopServer() {
        server.stop(0);
    }

    @SneakyThrows
    @Test
    void shouldDisplayYoyWidget() {
        String eventName = generateRandomString();
        app.signInPage.open();
        mockRateLimit();
        app.signInPage.signInWithEmailAndCode(testEmail, testCode)
            .openMePage()
            .clickCreateNewCommunityButton();
        app.createCommunityPage.createCommunity(generateRandom());
        app.communityPage.clickCreateEventBtn();
        app.mainEventPage.fillAndSubmitSettingEventForm(
            eventName, generateRandomDescription(), generateRandomString(),
            generateRandomString(), generateRandomString());
        app.ticketsEventPage.clickNextBtn();
        app.interactionsEventPage.clickNextBtn();
        app.registrationFormEventPage.clickNextBtn();
        app.publicationEventPage.clickNextBtn();
        app.eventPage.clickManageEventBtn();
        app.adminEventPage.clickTabVidzhetBtn();
        String eventId = app.adminEventPage.getWidgetEventId();
        CreateWidgetPage.create(eventId);
        open(pageUri.toString());
        app.iFramePage.clickRegisterBtn(eventId, generateRandomString(), generateRandomString(), testEmail, testPhone);
        app.iFramePage.verifyUserIsRegisteredForCurrentEvent(eventName);

    }
}
