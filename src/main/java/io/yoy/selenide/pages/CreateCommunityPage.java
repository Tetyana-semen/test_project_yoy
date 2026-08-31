package io.yoy.selenide.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTestId;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import io.yoy.selenide.utils.CommunityData;


public class CreateCommunityPage {

    public final SelenideElement communityTitle = $(byTestId("community-title"));
    public final SelenideElement communityNameInput = $(byTestId("community-name-input"));
    public final SelenideElement communityDescriptionInput = $(byTestId("community-description-input"));
    public final SelenideElement communityCreateSubmit = $(byTestId("community-create-submit"));
    public final SelenideElement formError = $(byTestId("form-error"));
    public final SelenideElement communityChatButton = $(byTestId("community-chat-row"));
    public final SelenideElement communityChatInput = $(byTestId("chat-composer-body"));
    public final SelenideElement communitySendButton = $(byTestId("chat-composer-send"));
    public final SelenideElement chatMessageBody = $(byTestId("chat-message-body"));

    public CreateCommunityPage verifyCommunityWithNameIsCreated(String communityName) {
        communityTitle.shouldHave(text(communityName));
        return this;
    }

    public CreateCommunityPage fillAndSubmitNewCommunityForm(String communityName, String communityDescription) {
        communityNameInput.setValue(communityName);
        communityDescriptionInput.setValue(communityDescription);
        communityCreateSubmit.click();
        return this;
    }

    public CreateCommunityPage verifyErrorMessageForTheURL(String errorMessage) {
        formError.shouldHave(text(errorMessage));
        return this;
    }

    public CreateCommunityPage clickOnCommunityChatButton() {
        communityChatButton.click();
        return this;
    }

    public CreateCommunityPage createNewMessage(String newMessage) {
        communityChatInput.click();
        communityChatInput.setValue(newMessage);
        communitySendButton.click();
        return this;
    }

    public CreateCommunityPage verifyNewMessagePresentInChat(String newMessage) {
        chatMessageBody.shouldBe(visible).shouldHave(text(newMessage));
        return this;
    }

    public CreateCommunityPage createCommunity(CommunityData data) {
        fillAndSubmitNewCommunityForm(data.name(), data.description());
        return this;
    }


}
