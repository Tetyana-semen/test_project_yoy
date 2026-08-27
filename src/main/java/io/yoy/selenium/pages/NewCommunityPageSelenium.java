package io.yoy.selenium.pages;

import static io.yoy.selenium.core.Elements.find;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

import io.yoy.selenide.utils.CommunityData;
import org.openqa.selenium.By;

public class NewCommunityPageSelenium {

    public final By communityNameInput = cssSelector("[data-testid='community-name-input']");
    public final By communityDescriptionInput = cssSelector("[data-testid='community-description-input']");
    public final By communityCreateSubmit = cssSelector("[data-testid='community-create-submit']");
    public final By communityChatButton = cssSelector("[data-testid='community-chat-row']");
    public final By communityChatInput = cssSelector("[data-testid='chat-composer-body']");
    public final By communitySendButton = cssSelector("[data-testid='chat-composer-send']");
    public final By chatMessageBody = cssSelector("[data-testid='chat-message-body']");
    public final By createNewCommunityBtn = xpath("//*[text()='Нова спільнота']");

    public NewCommunityPageSelenium clickCreateNewCommunityButton() {
        find(createNewCommunityBtn).waitFor().scrollIntoView();
        find(createNewCommunityBtn).click();
        return this;
    }

    public NewCommunityPageSelenium fillAndSubmitNewCommunityForm(CommunityData communityData) {
        find(communityNameInput).sendKeys(communityData.name());
        find(communityDescriptionInput).sendKeys(communityData.description());
        find(communityCreateSubmit).click();
        return this;
    }

    public NewCommunityPageSelenium clickOnCommunityChatButton() {
        find(communityChatButton).click();
        return this;
    }

    public NewCommunityPageSelenium createNewMessage(String newMessage) {
        find(communityChatInput).click();
        find(communityChatInput).sendKeys(newMessage);
        find(communitySendButton).click();
        return this;
    }

    public NewCommunityPageSelenium verifyNewMessagePresentInChat(String newMessage) {
        find(chatMessageBody).waitFor().containsText(newMessage);
        return this;
    }

}
