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
        app.signInPage.open();
        mockRateLimit();
        app.signInPage.signInWithEmailAndCode(testEmail, testCode)
            .openMePage()
            .clickCreateNewCommunityButton();
    }

    @Test
    public void shouldCreateNewCommunitySuccessfully() {
        CommunityData data = generateRandom();

        app.createCommunityPage.createCommunity(data)
            .verifyCommunityWithNameIsCreated(data.name());
    }

    @Test
    public void shouldShowValidationErrorWhenUsingTheSameURLForCommunity() {
        CommunityData data = generateRandom();

        app.createCommunityPage.createCommunity(data);

        app.mainPage.openMePage()
            .clickCreateNewCommunityButton()
            .createCommunity(data)
            .verifyErrorMessageForTheURL(ERROR_MESSAGE_FOR_URL);
    }

    @Test
    public void shouldSendAMessageInChat() {
        String newMessage = generateRandomString();

        app.createCommunityPage.createCommunity(generateRandom())
            .clickOnCommunityChatButton()
            .createNewMessage(newMessage)
            .verifyNewMessagePresentInChat(newMessage);
    }

}
