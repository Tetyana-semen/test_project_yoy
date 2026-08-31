package io.yoy.selenide.utils;

import net.datafaker.Faker;

public class DataFaker {
    public static final Faker faker = new Faker();

    public static String generateRandomString() {
        return faker.company().name();
    }

    public static String generateRandomDescription() {
        return faker.lorem().sentence();
    }

}
