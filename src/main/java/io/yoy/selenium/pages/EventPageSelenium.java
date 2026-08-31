package io.yoy.selenium.pages;

import static io.yoy.selenide.utils.DataFaker.generateRandomDescription;
import static io.yoy.selenide.utils.DataFaker.generateRandomString;
import static io.yoy.selenide.utils.FileUtils.getAbsolutePathFromClasspath;
import static io.yoy.selenium.core.Elements.find;
import static io.yoy.selenium.core.Elements.findAll;
import static org.openqa.selenium.By.cssSelector;

import io.yoy.selenide.utils.EventData;
import org.openqa.selenium.By;

public class EventPageSelenium {

    public final By createEventBtn = cssSelector("[data-testid='community-create-event-link']");
    public final By eventTitleInput = cssSelector("[data-testid='event-title-input']");
    public final By eventDescriptionInput = cssSelector("[data-testid='event-description-input']");
    public final By eventCityInput = cssSelector("[data-testid='event-city-input']");
    public final By eventCountryInput = cssSelector("[data-testid='event-country-input']");
    public final By eventLocationInput = cssSelector("[data-testid='event-location-input']");
    public final By addSpeakerBtn = cssSelector("[data-testid='add-speaker-toggle']");
    public final By newSpeakerName = cssSelector("#new_speaker_name");
    public final By speakerSaveBtn = cssSelector("#speaker_save_btn");
    public final By nextBtn = cssSelector("div > button[type=submit]");
    public final By manageEventBtn = cssSelector("[data-testid='manage-event-btn']");
    public final By tabUchasnyky = cssSelector("[data-testid='tab-uchasnyky']");
    public final By attendeesWhitelist = cssSelector("[data-testid='attendees-whitelist-import']");
    public final By whitelistSourceUpload = cssSelector("#whitelist-source-upload");
    public final By whitelistFileInput = cssSelector("[data-testid='whitelist-file']");
    public final By whitelistPrepare = cssSelector("[data-testid='whitelist-prepare']");
    public final By whitelistMapping = cssSelector("[data-testid='whitelist-mapping-continue']");
    public final By whitelistName = cssSelector("#whitelist-panel-upload > p");
    public final By whitelistMobileRows = cssSelector("article[data-testid^='whitelist-mobile-row-']");


    public EventPageSelenium uploadParticipantsListFile(String classpathFileName) {
        String absolutePath = getAbsolutePathFromClasspath(classpathFileName);
        find(whitelistFileInput).sendKeys(absolutePath);
        find(whitelistName).waitFor().visibility();
        find(whitelistPrepare).click();
        find(whitelistMapping).click();
        return this;
    }

    public EventPageSelenium openParticipantsList() {
        find(tabUchasnyky).click();
        find(attendeesWhitelist).click();
        find(whitelistSourceUpload).click();
        return this;
    }

    public EventPageSelenium verifyParticipantsCount(int expected) {
        findAll(whitelistMobileRows).shouldHaveSize(expected);
        return this;
    }

    public EventPageSelenium clickManageEventBtn() {
        find(manageEventBtn).click();
        return this;
    }

    public EventPageSelenium createNewEvent(String name, String city, String country) {
        EventData eventData = new EventData(
            name,
            generateRandomDescription(),
            city,
            country,
            generateRandomString(),
            generateRandomString());
        find(createEventBtn).click();
        fillAndSubmitSettingEventForm(eventData);
        find(nextBtn).click();
        find(nextBtn).click();
        find(nextBtn).click();
        find(nextBtn).click();
        return this;
    }

    public EventPageSelenium fillAndSubmitSettingEventForm(EventData data) {
        find(eventTitleInput).sendKeys(data.title());
        find(eventDescriptionInput).sendKeys(data.description());
        find(eventCityInput).sendKeys(data.city());
        find(eventCountryInput).sendKeys(data.country());
        find(eventLocationInput).sendKeys(data.location());
        find(addSpeakerBtn).waitFor().scrollIntoView();
        find(addSpeakerBtn).click();
        find(newSpeakerName).sendKeys(data.speakerName());
        find(speakerSaveBtn).click();
        find(nextBtn).click();
        return this;
    }
}
