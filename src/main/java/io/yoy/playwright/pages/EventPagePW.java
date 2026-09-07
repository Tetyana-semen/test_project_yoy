package io.yoy.playwright.pages;

import static io.yoy.selenide.utils.FileUtils.getAbsolutePathFromClasspath;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.yoy.selenide.utils.EventData;
import java.nio.file.Paths;

public class EventPagePW {

    private Page page;

    private final Locator createEventBtn = page.getByTestId("community-create-event-link");
    private final Locator eventTitleInput = page.getByTestId("event-title-input");
    private final Locator eventDescriptionInput = page.getByTestId("event-description-input");
    private final Locator eventCityInput = page.getByTestId("event-city-input");
    private final Locator eventCountryInput = page.getByTestId("event-country-input");
    private final Locator eventLocationInput = page.getByTestId("event-location-input");
    private final Locator addSpeakerBtn = page.getByTestId("add-speaker-toggle");
    private final Locator newSpeakerName = page.locator("#new_speaker_name");
    private final Locator speakerSaveBtn = page.locator("#speaker_save_btn");
    private final Locator nextBtn = page.locator("div > button[type=submit]");;
    private final Locator manageEventBtn = page.getByTestId("manage-event-btn");
    private final Locator tabUchasnyky = page.getByTestId("tab-uchasnyky");;
    private final Locator attendeesWhitelist = page.getByTestId("attendees-whitelist-import");
    private final Locator whitelistSourceUpload = page.locator("#whitelist-source-upload");
    private final Locator whitelistFileInput = page.getByTestId("whitelist-file");
    private final Locator whitelistPrepare = page.getByTestId("whitelist-prepare");
    private final Locator whitelistMapping = page.getByTestId("whitelist-mapping-continue");
    private final Locator whitelistName = page.locator("#whitelist-panel-upload > p");;
    private final Locator whitelistMobileRows = page.locator("article[data-testid^='whitelist-mobile-row-']");
    private final Locator eventTitle = page.getByTestId("event-title");
    private final Locator eventDescription = page.getByTestId("event-description");

    public EventPagePW(Page page) {
        this.page = page;
    }

    public EventPagePW uploadParticipantsListFile(String classpathFileName) {
        String absolutePath = getAbsolutePathFromClasspath(classpathFileName);

        whitelistFileInput.setInputFiles(Paths.get(absolutePath));
        whitelistName.waitFor();
        whitelistPrepare.click();
        whitelistMapping.click();
        return this;
    }

    public EventPagePW openParticipantsList() {
        tabUchasnyky.click();
        attendeesWhitelist.click();
        whitelistSourceUpload.click();
        return this;
    }

    public EventPagePW verifyParticipantsCount(int expected) {
        assertThat(whitelistMobileRows).hasCount(expected);
        return this;
    }

    public EventPagePW clickManageEventBtn() {
        manageEventBtn.click();

        return this;
    }

    public EventPagePW createNewEvent(EventData eventData) {
        createEventBtn.click();

        fillAndSubmitSettingEventForm(eventData);

        nextBtn.click();
        nextBtn.click();
        nextBtn.click();
        nextBtn.click();
        return this;
    }

    public EventPagePW fillAndSubmitSettingEventForm(EventData data) {
        eventTitleInput.fill(data.title());
        eventDescriptionInput.fill(data.description());
        eventCityInput.fill(data.city());
        eventCountryInput.fill(data.country());
        eventLocationInput.fill(data.location());

        addSpeakerBtn.scrollIntoViewIfNeeded();
        addSpeakerBtn.click();

        newSpeakerName.fill(data.speakerName());
        speakerSaveBtn.click();

        nextBtn.click();
        return this;
    }

    public EventPagePW verifyEventIsCreated (EventData data) {
        assertThat(eventTitle).hasText(data.title());
        assertThat(eventDescription).hasText(data.description());
        return this;

    }

}
