package com.mts.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CompletePage {

    private final Locator confirmationMessage;

    public CompletePage(Page page) {
        this.confirmationMessage = page.locator("[data-test='complete-header']");
    }

    public void verifyPurchaseCompleted() {
        assertThat(confirmationMessage)
                .hasText("Thank you for your order!");
    }
}