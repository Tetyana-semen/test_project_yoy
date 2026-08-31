package io.yoy.selenide.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byTestId;
import static com.codeborne.selenide.Selenide.$;
import static io.yoy.selenide.utils.WaitUtils.waitUntilElementIsReady;

import com.codeborne.selenide.SelenideElement;

public class EventPage {

    public final SelenideElement manageEventBtn = $(byTestId("manage-event-btn"));
    public final SelenideElement assistantTriggerBtn = $(byTestId("assistant-trigger"));
    public final SelenideElement assistantInput = $(byTestId("assistant-input"));
    public final SelenideElement assistantSend = $(byTestId("assistant-send"));
    public final SelenideElement assistantProposalConfirm = $(byTestId("assistant-proposal-confirm"));
    public final SelenideElement eventTitle = $(byTestId("event-admin-title"));
    public final SelenideElement eventsPageBtn = $(by("href", "/events"));


    public EventPage clickManageEventBtn() {
        manageEventBtn.click();
        return this;
    }

    public EventPage clickEventsPageBtn() {
        eventsPageBtn.click();
        return this;
    }

    public EventPage clickAssistantTriggerBtn() {
        assistantTriggerBtn.click();
        return this;
    }

    public EventPage typeAndSendMessageInAIChat(String text) {
        assistantInput.setValue(text);
        assistantSend.click();
        waitUntilElementIsReady(assistantProposalConfirm);
        assistantProposalConfirm.click();
        assistantProposalConfirm.shouldNotBe(visible);
        return this;
    }

    public EventPage verifyEventTitleUpdated(String expectedEventTitle) {
        eventTitle.shouldHave(text(expectedEventTitle));
        return this;
    }



}
