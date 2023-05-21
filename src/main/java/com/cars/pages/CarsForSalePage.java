package com.cars.pages;

import com.cars.elements.BasicFilterSection;
import com.cars.models.CarForSearch;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

import java.util.Optional;

public class CarsForSalePage extends BasePage {

    private static final String HEADER = "//h1[text()='%s']";
    private static final String CAR_CARD = "//div[@class='vehicle-card   '][%s]//a[contains(@class, 'vehicle-card-link')]";

    private final BasicFilterSection filterSection;

    public CarsForSalePage(Page page, Optional<CarForSearch> optionalCar) {
        this.page = page;
        CarForSearch car = optionalCar.orElse(null);
        checkElementVisible(String.format(HEADER, constructHeader(car)));
        this.filterSection = new BasicFilterSection(this.page);
    }

    @Step
    public CarPage openCarCard(int cardNum) {
        page.locator(String.format(CAR_CARD, cardNum))
                .click();
        return new CarPage(page);
    }

    public BasicFilterSection getFilterSection() {
        return filterSection;
    }

    private String constructHeader(CarForSearch car) {
        return car == null ? "Cars for sale"
                : car.getNewUsed() + " " +
                car.getMake() + " " +
                car.getModel() + " " +
                "for sale";
    }
}
