package io.yoy;

import static com.codeborne.selenide.Selenide.open;
import static utils.DataFaker.generateRandomDescription;
import static utils.DataFaker.generateRandomString;
import static utils.storage.ContextKey.COMMUNITY_NAME;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;
import io.yoy.hooks.CommunityCleanupExtension;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.CreateWidgetPage;
import utils.CommunityData;

@ExtendWith(CommunityCleanupExtension.class)
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
        CommunityData community = CommunityData.generateRandom();
        String eventName = generateRandomString();

        loginToYoy();
        createNewCommunity(community);
        createNewEvent(eventName, "Rivne");
        app.eventPage.clickManageEventBtn();
        app.adminEventPage.clickTabVidzhetBtn();
        String eventId = app.adminEventPage.getWidgetEventId();
        CreateWidgetPage.create(eventId);
        open(pageUri.toString());
        app.iFramePage.registerToEvent(eventId, generateRandomString(), generateRandomString(), testEmail, testPhone);
        app.iFramePage.verifyUserIsRegisteredForCurrentEvent(eventName);
        loginToYoy();

        app.context.setContext(COMMUNITY_NAME, community.name());
    }

    public static void createNewCommunity(CommunityData community) {
        app.mainPage.openMePage();
        app.mePage.clickCreateNewCommunityButton();
        app.createCommunityPage.createCommunity(community);
    }

    public static void createNewEvent(String eventName, String eventCity) {
        app.communityPage.clickCreateEventBtn();
        app.mainEventPage.fillAndSubmitSettingEventForm(
            eventName, generateRandomDescription(), eventCity,
            generateRandomString(), generateRandomString(), LocalDate.now());
        app.ticketsEventPage.clickNextBtn();
        app.interactionsEventPage.clickNextBtn();
        app.registrationFormEventPage.clickNextBtn();
        app.publicationEventPage.clickNextBtn();
    }

    public void loginToYoy() {
        app.signInPage.open();
        mockRateLimit();
        app.signInPage.signInWithEmailAndCode(testEmail, testCode);
    }
}
