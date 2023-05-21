package com.cars.elements;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import io.qameta.allure.Step;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class BasicFilterSection {

    private final static String SELECT = "//div[@id='search-basics-area']//label[text()='%s']/parent::div/select";
    private final static String ACTIVE_TAG = "div#active_filter_tags label";
    private final Page page;

    public BasicFilterSection(Page page) {
        this.page = page;
    }

    @Step
    public BasicFilterSection selectDropdown(String label, String value) {
        page.selectOption("//div[@id='search-basics-area']//select[@id='stock-type-select']", value);
        page.selectOption(String.format(SELECT, label), value);
//        page.getByLabel(label).selectOption(value);
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        return this;
    }

    public List<String> getActiveTags() {
        return page.locator(ACTIVE_TAG).allTextContents()
                .stream().map(String::trim).collect(toList());
    }
}
