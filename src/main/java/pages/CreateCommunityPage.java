package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import utils.CommunityData;


public class CreateCommunityPage {

    public final SelenideElement communityTitle = $("[data-testid='community-title']");
    public final SelenideElement communityNameInput = $("[data-testid='community-name-input']");
    public final SelenideElement communityDescriptionInput = $("[data-testid='community-description-input']");
    public final SelenideElement communityCreateSubmit = $("[data-testid='community-create-submit']");
    public final SelenideElement emailError = $("#signin-email-error");
    public final SelenideElement formError = $("[data-testid='form-error']");
    public final SelenideElement communityChatButton = $("[data-testid='community-chat-row']");
    public final SelenideElement communityChatInput = $("[data-testid='chat-composer-body']");
    public final SelenideElement communitySendButton = $("[data-testid='chat-composer-send']");
    public final SelenideElement chatMessageBody = $("[data-testid='chat-message-body']");


    public void verifyCommunityWithNameIsCreated(String communityName) {
        communityTitle.shouldHave(text(communityName));
    }

    public void fillAndSubmitNewCommunityForm(String communityName, String communityDescription) {
        communityNameInput.setValue(communityName);
        communityDescriptionInput.setValue(communityDescription);
        communityCreateSubmit.click();
    }

    public void verifyErrorMessageForTheURL(String errorMessage) {
        formError.shouldHave(text(errorMessage));
    }

    public void clickOnCommunityChatButton() {
        communityChatButton.click();
    }

    public void createNewMessage(String newMessage) {
        communityChatInput.click();
        communityChatInput.setValue(newMessage);
        communitySendButton.click();

    }

    public void verifyNewMessagePresentInChat(String newMessage) {
        chatMessageBody.shouldBe(visible).shouldHave(text(newMessage));

    }

    public String createCommunity(CommunityData data) {
        fillAndSubmitNewCommunityForm(data.name(), data.description());
        return data.name();
    }

}
