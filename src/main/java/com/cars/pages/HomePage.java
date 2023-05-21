package com.cars.pages;

import com.cars.elements.SearchForm;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class HomePage extends BasePage {

    private static final String HOMEPAGE_BANNER = "section#primary-hero";

    private final SearchForm searchForm;

    public HomePage(Page page) {
        this.page = page;
        checkElementVisible(HOMEPAGE_BANNER);
        this.searchForm = new SearchForm(page);
    }

    @Step
    public SearchForm getSearchForm() {
        return searchForm;
    }
}
