package com.mts.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutOverviewPage {

    private final Locator finishButton;

    public CheckoutOverviewPage(Page page) {
        this.finishButton = page.locator("[data-test='finish']");
    }

    public void finishPurchase() {
        finishButton.click();
    }
}