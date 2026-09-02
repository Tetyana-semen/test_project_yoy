package io.yoy.playwright.pages;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.yoy.selenide.utils.CommunityData;

public class NewCommunityPagePW {

    private Page page;

    private final Locator communityNameInput = page.getByTestId("community-name-input");
    private final Locator communityDescriptionInput = page.getByTestId("community-description-input");
    private final Locator communityCreateSubmit = page.getByTestId("community-create-submit");
    private final Locator communityChatButton = page.getByTestId("community-chat-row");
    private final Locator communityChatInput = page.getByTestId("chat-composer-body");
    private final Locator communitySendButton = page.getByTestId("chat-composer-send");
    private final Locator chatMessageBody = page.getByTestId("chat-message-body");
    private final Locator createNewCommunityBtn = page.getByText("Нова спільнота");
    private final Locator communityRow = page.getByTestId("community-public-row");;
    private final Locator communityUpcomingEvent = page.getByTestId("community-upcoming-event-card");
    private final Locator registerCta = page.getByTestId("register-cta");;
    private final Locator communitiesBtn = page.locator("a[href='/communities']");;

    public NewCommunityPagePW(Page page) {
        this.page = page;
    }

    public NewCommunityPagePW clickCreateNewCommunityButton() {
        createNewCommunityBtn.scrollIntoViewIfNeeded();
        createNewCommunityBtn.click();
        return this;
    }

    public NewCommunityPagePW fillAndSubmitNewCommunityForm(CommunityData communityData) {
        communityNameInput.fill(communityData.name());
        communityDescriptionInput.fill(communityData.description());
        communityCreateSubmit.click();
        return this;
    }

    public NewCommunityPagePW clickOnCommunityChatButton() {
        communityChatButton.click();
        return this;
    }

    public NewCommunityPagePW createNewMessage(String newMessage) {
        communityChatInput.fill(newMessage);
        communitySendButton.click();
        return this;
    }

    public NewCommunityPagePW verifyNewMessagePresentInChat(String newMessage) {
        assertThat(chatMessageBody.first()).containsText(newMessage);
        return this;
    }

    public NewCommunityPagePW chooseCommunityAndEvent() {
        communityRow.first().click();
        communityUpcomingEvent.click();
        return this;
    }

    public NewCommunityPagePW registerToEvent() {
        registerCta.click();
        return this;
    }

    public NewCommunityPagePW clickCommunitiesBtn() {
        communitiesBtn.click();
        return this;
    }

}
