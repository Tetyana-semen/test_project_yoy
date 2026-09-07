package io.yoy.playwright.tests;

import static io.yoy.selenide.utils.DataFaker.generateRandomString;

import com.microsoft.playwright.junit.UsePlaywright;
import io.yoy.playwright.common.PWOptions;
import io.yoy.selenide.utils.CommunityData;
import io.yoy.selenide.utils.EventData;
import org.junit.jupiter.api.Test;

@UsePlaywright(PWOptions.class)
public class PlaywrightTests extends BasePlaywrightTest{

    @Test
    void shouldSendAMessageInChatPW() {
        CommunityData community = CommunityData.generateRandom();
        String newMessage = generateRandomString();

        app.communityPagePW
            .clickCreateNewCommunityButton()
            .fillAndSubmitNewCommunityForm(community)
            .clickOnCommunityChatButton()
            .createNewMessage(newMessage)
            .verifyNewMessagePresentInChat(newMessage);
    }

    @Test
    void shouldReadAllParticipantsFromExcelPW() {
        CommunityData community = CommunityData.generateRandom();
        EventData eventData = EventData.generateRandom();

        app.communityPagePW
            .clickCreateNewCommunityButton()
            .fillAndSubmitNewCommunityForm(community);

        app.eventPagePW
            .createNewEvent(eventData)
            .clickManageEventBtn()
            .openParticipantsList()
            .uploadParticipantsListFile("testData/participants.xlsx")
            .verifyParticipantsCount(10);
    }

    @Test
    void attendeeShouldSeeTicketForEventCreatedByOrganizer() {
        CommunityData community = CommunityData.generateRandom();
        EventData eventData = EventData.generateRandom();

        app.communityPagePW
            .clickCreateNewCommunityButton()
            .fillAndSubmitNewCommunityForm(community);
        app.eventPagePW
            .createNewEvent(eventData)
            .verifyEventIsCreated(eventData);
        app.signInPagePW
            .switchUser(secondTestEmail, testCode);
        app.communityPagePW
            .clickCommunitiesBtn()
            .chooseCommunityAndEvent()
            .registerToEvent();
        app.ticketsPagePW
            .moveToTicketsTabAndVerifyTicketIsPresent(eventData.title());

    }
}
