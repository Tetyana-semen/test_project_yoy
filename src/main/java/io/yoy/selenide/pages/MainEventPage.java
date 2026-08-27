package io.yoy.selenide.pages;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byTestId;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.cssSelector;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;

public class MainEventPage {

    public final SelenideElement eventTitleInput = $(byTestId("event-title-input"));
    public final SelenideElement eventDescriptionInput = $(byTestId("event-description-input"));
    public final SelenideElement eventCityInput = $(byTestId("event-city-input"));
    public final SelenideElement eventLocationInput = $(byTestId("event-location-input"));
    public final SelenideElement addSpeakerBtn = $(byTestId("add-speaker-toggle"));
    public final SelenideElement newSpeakerName = $(byId("new_speaker_name"));
    public final SelenideElement speakerSaveBtn = $(byId("speaker_save_btn"));
    public final SelenideElement eventEndsAt = $(byId("ends_at_display"));
    public final SelenideElement eventStartsAt = $(byTestId("event-starts-at-input"));
    public final SelenideElement eventCountryInput = $(byTestId("event-country-input"));
    public final SelenideElement nextBtn = $("div > button[type=submit]");


    public MainEventPage fillAndSubmitSettingEventForm(String title, String description, String city, String country, String location, String speakerName, LocalDate dateTime) {
        eventTitleInput.setValue(title);
        eventDescriptionInput.setValue(description);
        setStartDate(LocalDateTime.now().plusMinutes(5).withSecond(0).withNano(0));
        setEndsDate(LocalDateTime.now().plusMinutes(30).withSecond(0).withNano(0));
        eventCityInput.setValue(city);
        eventCountryInput.setValue(country);
        eventLocationInput.setValue(location);
        addSpeakerBtn.scrollIntoView(true).click();
        newSpeakerName.setValue(speakerName);
        speakerSaveBtn.click();
        nextBtn.click();
        return this;
    }

    public void setStartDate(LocalDateTime dateTime) {
        String isoValue = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

        Selenide.executeJavaScript(
            "arguments[0].value = arguments[1];" +
                "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
                "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
            eventStartsAt, isoValue
        );
    }

    public void setEndsDate(LocalDateTime dateTime) {
        String isoValue = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

        Selenide.executeJavaScript(
            "arguments[0].value = arguments[1];" +
                "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
                "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
            eventEndsAt, isoValue
        );
    }

}
