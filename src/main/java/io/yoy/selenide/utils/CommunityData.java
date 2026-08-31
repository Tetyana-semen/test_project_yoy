package io.yoy.selenide.utils;

import static io.yoy.selenide.utils.DataFaker.generateRandomDescription;
import static io.yoy.selenide.utils.DataFaker.generateRandomString;

public record CommunityData(String name, String description) {

    public static CommunityData generateRandom() {
        return new CommunityData(generateRandomString(), generateRandomDescription());
    }
}


