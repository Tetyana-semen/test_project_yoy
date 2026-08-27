package io.yoy.selenide.tests;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.attribute;
import static io.yoy.selenide.tests.WidgetPageTest.createNewCommunity;
import static io.yoy.selenide.tests.WidgetPageTest.createNewEvent;
import static org.assertj.core.api.Assertions.assertThat;
import static io.yoy.selenide.utils.DataFaker.generateRandomString;
import static io.yoy.selenide.utils.storage.ContextKey.COMMUNITY_NAME;

import com.codeborne.selenide.ElementsCollection;
import io.yoy.selenide.hooks.CommunityCleanupExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import io.yoy.selenide.utils.CommunityData;

@ExtendWith(CommunityCleanupExtension.class)
public class EventTests extends BaseTest {

    @BeforeEach
    void openAndSignInYoy() {
        app.signInPage.open();
        mockRateLimit();
        app.signInPage.signInWithEmailAndCode(testEmail, testCode);
    }

    @Test
    public void shouldShowEventOnListOfAllEvents() {
        String eventName = generateRandomString();
        String eventCity = "Rivne";
        CommunityData community = CommunityData.generateRandom();

        createNewCommunity(community);
        createNewEvent(eventName, eventCity, "UA");
        app.eventPage.clickEventsPageBtn();

        ElementsCollection kyivEvents = app.eventsPage.getEventCards()
            .filterBy(attribute("data-event-city", eventCity));
        System.out.println("kyivEvents: " + kyivEvents.texts());
        kyivEvents.shouldHave(sizeGreaterThan(0));
        kyivEvents.forEach(el ->
            assertThat(el.getAttribute("data-event-city")).isEqualTo(eventCity)
        );

        app.context.setContext(COMMUNITY_NAME, community.name());
    }

    @Test
    public void shouldChangeEventNameUsingAIChat() {
        String eventName = generateRandomString();
        String eventCity = "Rivne";
        CommunityData community = CommunityData.generateRandom();

        createNewCommunity(community);
        createNewEvent(eventName, eventCity, "UA");
        app.eventPage.clickManageEventBtn();
        app.eventPage.clickAssistantTriggerBtn();
        app.eventPage.typeAndSendMessageInAIChat("change event name to 'Updated event name using AI'");
        refreshPage();
        app.eventPage.verifyEventTitleUpdated("Updated event name using AI");

        app.context.setContext(COMMUNITY_NAME, community.name());
    }

}
