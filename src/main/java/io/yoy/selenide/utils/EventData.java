package io.yoy.selenide.utils;

import static io.yoy.selenide.utils.DataFaker.generateRandomDescription;
import static io.yoy.selenide.utils.DataFaker.generateRandomString;

public record EventData(
    String title,
    String description,
    String city,
    String country,
    String location,
    String speakerName
) {

    public static EventData generateRandom() {
        return new EventData(
            generateRandomString(),
            generateRandomDescription(),
            generateRandomString(),
            generateRandomString(),
            generateRandomString(),
            generateRandomString()
        );
    }

    public static EventData generateRandom(String title, String city, String country) {
        return new EventData(
            title,
            generateRandomDescription(),
            city,
            country,
            generateRandomString(),
            generateRandomString()
        );
    }
}
