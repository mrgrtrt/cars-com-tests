package com.cars.elements;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import io.qameta.allure.Step;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class BasicFilterSection {

    private final static String SELECT = "//div[@id='search-basics-area']//label[text()='%s']/parent::div";
    private final static String ACTIVE_TAG = "div#active_filter_tags label";
    private final Page page;

    public BasicFilterSection(Page page) {
        this.page = page;
    }

    @Step
    public BasicFilterSection selectDropdown(String label, String value) {
        //this dropdown in chromium has issues
        page.click(String.format(SELECT, label));
        page.click(String.format(SELECT, label));

        page.selectOption("#stock-type-select", value);
        page.waitForLoadState(LoadState.LOAD);
        page.waitForLoadState();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public List<String> getActiveTags() {
        return page.locator(ACTIVE_TAG).allTextContents()
                .stream().map(String::trim).collect(toList());
    }
}
