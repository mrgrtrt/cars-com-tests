package com.cars;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import static com.cars.utils.ConfigUtils.ConfigKeys.HEADLESS;
import static com.cars.utils.ConfigUtils.DEFAULTS;

public class PlaywrightContext {
    private final Browser browser;

    public PlaywrightContext() {
        Playwright playwright = Playwright.create();
        this.browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(Boolean.parseBoolean(DEFAULTS.get(HEADLESS))));
    }

    public Browser getChromeBrowser() {
        return browser;
    }
}
