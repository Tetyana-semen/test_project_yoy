package pages;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byTestId;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class MainEventPage {

    public final SelenideElement eventTitleInput = $(byTestId("event-title-input"));
    public final SelenideElement eventDescriptionInput = $(byTestId("event-description-input"));
    public final SelenideElement eventCityInput = $(byTestId("event-city-input"));
    public final SelenideElement eventLocationInput = $(byTestId("event-location-input"));
    public final SelenideElement addSpeakerBtn = $(byTestId("add-speaker-toggle"));
    public final SelenideElement newSpeakerName = $(byId("new_speaker_name"));
    public final SelenideElement speakerSaveBtn = $(byId("speaker_save_btn"));
    public final SelenideElement nextBtn = $("div > button[type=submit]");

    public MainEventPage fillAndSubmitSettingEventForm(String eventTitle, String eventDescription, String eventCity, String eventLocation, String speakerName) {
        eventTitleInput.setValue(eventTitle);
        eventDescriptionInput.setValue(eventDescription);
        eventCityInput.setValue(eventCity);
        eventLocationInput.setValue(eventLocation);
        addSpeakerBtn.click();
        newSpeakerName.setValue(speakerName);
        speakerSaveBtn.click();
        nextBtn.click();
        return this;
    }
}
