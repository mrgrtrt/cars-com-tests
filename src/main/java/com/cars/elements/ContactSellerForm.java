package com.cars.elements;

import com.cars.models.ContactSeller;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class ContactSellerForm {

    private final Page page;

    public ContactSellerForm(Page page) {
        this.page = page;
    }

    @Step
    public ContactSellerForm fillContactSellerForm(ContactSeller contactSeller) {
        fillInput("First name", contactSeller.getFirstName())
                .fillInput("Last name", contactSeller.getLastName())
                .fillInput("Email", contactSeller.getEmail());
        return this;
    }

    @Step
    public ContactSellerForm fillInput(String label, String value) {
        page.getByLabel(label).fill(value);
        return this;
    }
}
