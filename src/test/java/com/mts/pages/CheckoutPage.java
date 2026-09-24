package com.mts.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutPage {

    private final Locator firstName;
    private final Locator lastName;
    private final Locator postalCode;
    private final Locator continueButton;

    public CheckoutPage(Page page) {
        // Locators
        this.firstName = page.locator("[data-test='firstName']");
        this.lastName = page.locator("[data-test='lastName']");
        this.postalCode = page.locator("[data-test='postalCode']");
        this.continueButton = page.locator("[data-test='continue']");
    }

    public void fillInformation(String firstName, String lastName, String postalCode) {
        this.firstName.fill(firstName);
        this.lastName.fill(lastName);
        this.postalCode.fill(postalCode);
    }

    public void continueCheckout() {
        continueButton.click();
    }
}