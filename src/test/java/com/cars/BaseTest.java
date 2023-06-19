package com.cars;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Objects;

import static com.cars.utils.ConfigUtils.ConfigKeys.TIMEOUT;
import static com.cars.utils.ConfigUtils.ConfigKeys.URL;
import static com.cars.utils.ConfigUtils.DEFAULTS;
import static org.testng.Assert.assertTrue;

public class BaseTest {

    protected Browser browser;
    protected Page page;

    @BeforeSuite
    public void initBrowser() {
        browser = new PlaywrightContext().getChromeBrowser();
        page = browser.newPage();
        page.setDefaultTimeout(Double.parseDouble(DEFAULTS.get(TIMEOUT)));
        page.navigate(DEFAULTS.get(URL));
    }

    @AfterSuite
    public void tearDown() {
        browser.close();
    }
}
