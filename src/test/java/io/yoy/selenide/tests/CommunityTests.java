package io.yoy.selenide.tests;

import static io.yoy.selenide.utils.DataFaker.generateRandomString;
import static io.yoy.selenide.utils.storage.ContextKey.COMMUNITY_NAME;

import io.yoy.selenide.hooks.CommunityCleanupExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import io.yoy.selenide.utils.CommunityData;

@ExtendWith(CommunityCleanupExtension.class)
public class CommunityTests extends BaseTest {

    public static final String ERROR_MESSAGE_FOR_URL = " Цей URL вже зайнятий";

    @BeforeEach
    void openAndSignInYoy() {
        app.signInPage.open();
        mockRateLimit();
        app.signInPage.signInWithEmailAndCode(testEmail, testCode);
        app.mainPage.openMePage();
        app.mePage.clickCreateNewCommunityButton();
    }

    @Test
    public void shouldCreateNewCommunitySuccessfully() {
        CommunityData community = CommunityData.generateRandom();

        app.createCommunityPage.createCommunity(community)
            .verifyCommunityWithNameIsCreated(community.name());

        app.context.setContext(COMMUNITY_NAME, community.name());
    }

    @Test
    public void shouldShowValidationErrorWhenUsingTheSameURLForCommunity() {
        CommunityData community = CommunityData.generateRandom();

        app.createCommunityPage.createCommunity(community);

        app.mainPage.openMePage();
        app.mePage.clickCreateNewCommunityButton();
        app.createCommunityPage.createCommunity(community)
            .verifyErrorMessageForTheURL(ERROR_MESSAGE_FOR_URL);

        app.context.setContext(COMMUNITY_NAME, community.name());
    }

    @Test
    public void shouldSendAMessageInChat() {
        CommunityData community = CommunityData.generateRandom();
        String newMessage = generateRandomString();

        app.createCommunityPage.createCommunity(community)
            .clickOnCommunityChatButton()
            .createNewMessage(newMessage)
            .verifyNewMessagePresentInChat(newMessage);

        app.context.setContext(COMMUNITY_NAME, community.name());
    }

}
