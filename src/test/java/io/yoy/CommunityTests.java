package io.yoy;

import static utils.CommunityData.generateRandom;
import static utils.DataFaker.generateRandomString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.CommunityData;

public class CommunityTests extends BaseTest {

    public static final String ERROR_MESSAGE_FOR_URL = " Цей URL вже зайнятий";

    @BeforeEach
    void openAndSignInYoy() {
        signInPage.open();
        mockRateLimit();
        signInPage.signInWithEmailAndCode(testEmail, testCode);
        mainPage.openMePage();
        eventsMePage.clickCreateNewCommunityButton();
    }

    @Test
    public void shouldCreateNewCommunitySuccessfully() {
        String communityName = createCommunityPage.createCommunity(generateRandom());
        createCommunityPage.verifyCommunityWithNameIsCreated(communityName);
    }

    @Test
    public void shouldShowValidationErrorWhenUsingTheSameURLForCommunity() {
        CommunityData data = generateRandom();

        createCommunityPage.createCommunity(data);
        mainPage.openMePage();
        eventsMePage.clickCreateNewCommunityButton();
        createCommunityPage.createCommunity(data);
        createCommunityPage.verifyErrorMessageForTheURL(ERROR_MESSAGE_FOR_URL);
    }

    @Test
    public void shouldSendAMessageInChat() {
        String newMessage = generateRandomString();

        createCommunityPage.createCommunity(generateRandom());
        createCommunityPage.clickOnCommunityChatButton();
        createCommunityPage.createNewMessage(newMessage);
        createCommunityPage.verifyNewMessagePresentInChat(newMessage);
    }

}
