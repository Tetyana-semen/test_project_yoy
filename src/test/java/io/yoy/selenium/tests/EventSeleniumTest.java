package io.yoy.selenium.tests;

import static io.yoy.selenide.utils.DataFaker.generateRandomString;

import io.yoy.selenide.utils.CommunityData;
import io.yoy.selenium.common.LoginYoy;
import io.yoy.selenium.common.WebDriverLifeCycleExtension;
import io.yoy.selenium.pages.EventPageSelenium;
import io.yoy.selenium.pages.NewCommunityPageSelenium;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({WebDriverLifeCycleExtension.class, LoginYoy.class})
class EventSeleniumTest {

    @Test
    void shouldSendAMessageInChat() {
        CommunityData community = CommunityData.generateRandom();
        String newMessage = generateRandomString();

        new NewCommunityPageSelenium()
            .clickCreateNewCommunityButton()
            .fillAndSubmitNewCommunityForm(community)
            .clickOnCommunityChatButton()
            .createNewMessage(newMessage)
            .verifyNewMessagePresentInChat(newMessage);

    }

    @Test
    void shouldReadALlParticipantsFromExcel() {
        CommunityData community = CommunityData.generateRandom();

        new NewCommunityPageSelenium()
            .clickCreateNewCommunityButton()
            .fillAndSubmitNewCommunityForm(community);
        new EventPageSelenium()
            .createNewEvent(generateRandomString(), "Rivne", "UA")
            .clickManageEventBtn()
            .openParticipantsList()
            .uploadParticipantsListFile("testData/participants.xlsx")
            .verifyParticipantsCount(10);
    }

}