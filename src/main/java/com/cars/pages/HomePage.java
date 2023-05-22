package com.cars.pages;

import com.cars.elements.SearchForm;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    private final SearchForm searchForm;

    public HomePage(Page page) {
        super(page);
        this.searchForm = new SearchForm(page);
    }

    public SearchForm getSearchForm() {
        return searchForm;
    }
}
