package utils;

import static utils.DataFaker.generateRandomDescription;
import static utils.DataFaker.generateRandomString;

public record CommunityData(String name, String description) {

    public static CommunityData generateRandom() {
        return new CommunityData(generateRandomString(), generateRandomDescription());
    }
}


