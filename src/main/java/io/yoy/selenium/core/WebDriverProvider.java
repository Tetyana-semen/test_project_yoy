package io.yoy.selenium.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class WebDriverProvider {

    private static final ThreadLocal<WebDriver> driverThreadLocal = ThreadLocal.withInitial(
        ChromeDriver::new);

    public static WebDriver driver() {
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}