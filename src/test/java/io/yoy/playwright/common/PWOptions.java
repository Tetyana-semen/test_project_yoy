package io.yoy.playwright.common;

import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;

public class PWOptions implements OptionsFactory {

    @Override
    public Options getOptions() {
        return new Options()
            .setHeadless(false)
            .setBaseUrl("https://test.yoy.events/");
    }
}
