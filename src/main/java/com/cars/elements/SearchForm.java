package com.cars.elements;

import com.cars.models.CarForSearch;
import com.cars.pages.CarsForSalePage;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import io.qameta.allure.Step;

import java.util.Optional;

public class SearchForm {

    private static final String SEARCH_BUTTON = "div#by-make-tab button";
    private static final String SELECT = "//div[@id='by-make-tab']//select[@data-activitykey='%s']";
    private static final String INPUT = "//div[@id='by-make-tab']//input[@data-activitykey='%s']";
    private final Page page;

    public SearchForm(Page page) {
        this.page = page;
    }

    public CarsForSalePage fillAndSearchCar(CarForSearch car) {
        return selectOption("stock-type", car.getNewUsed())
                .selectOption("make", car.getMake())
                .selectOption("model", car.getModel())
                .selectOption("price", car.getPrice())
                .selectOption("distance", car.getDistance())
                .enterText("zip", car.getZip())
                .clickSearchButton(car);
    }

    @Step
    public SearchForm selectOption(String id, String option) {
        page.selectOption(String.format(SELECT, id), option);
        return this;
    }

    @Step
    public SearchForm enterText(String id, String text) {
        page.fill(String.format(INPUT, id), text);
        return this;
    }

    @Step
    public CarsForSalePage clickSearchButton(CarForSearch car) {
        page.locator(SEARCH_BUTTON).click();
        page.waitForLoadState(LoadState.LOAD);

        return new CarsForSalePage(page, Optional.of(car));
    }
}
