package com.cars.pages;

import com.cars.elements.ContactSellerForm;
import com.microsoft.playwright.Page;

public class CarPage extends BasePage {

    private ContactSellerForm contactSeller;

    public CarPage(Page page) {
        super(page);
        contactSeller = new ContactSellerForm(page);
    }

    public ContactSellerForm getContactSeller() {
        return contactSeller;
    }
}
