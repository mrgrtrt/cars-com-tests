package com.cars;

import com.cars.models.CarForSearch;
import com.cars.models.CarForSearchBuilder;
import com.cars.models.ContactSeller;
import com.cars.pages.CarsForSalePage;
import com.cars.pages.HomePage;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CarsComTest extends BaseTest {

    @Test(description = "Search the Car")
    void verifySearchCarCard() {
        CarForSearch car = new CarForSearchBuilder()
                .setNewUsed("Used")
                .setMake("Honda")
                .setModel("Pilot")
                .setPrice("$50,000")
                .setDistance("100 miles")
                .setZip("60008")
                .build();


        CarsForSalePage carsForSalePage = new HomePage(page)
                .getSearchForm()
                .fillAndSearchCar(car);

        List<String> activeTags = carsForSalePage
                .getFilterSection()
                .selectDropdown("New/used", "new")
                .getActiveTags();

        assertTrue(activeTags.contains("New"), "No expected tag!");
        assertFalse(activeTags.contains("Used"), "Incorrect tag shown!");

        ContactSeller contact = new ContactSeller("Car", "Owner", "carowner@yahoo.com");
        carsForSalePage.openCarCard(2)
                .getContactSeller()
                .fillContactSellerForm(contact);
    }
}
