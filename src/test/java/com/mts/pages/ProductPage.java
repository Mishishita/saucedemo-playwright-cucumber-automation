package com.mts.pages;

import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

import com.microsoft.playwright.Locator;

public class ProductPage {

    private final Locator title;
    private final Locator addBackpackButton;
    private final Locator cartBadge;
    private final Locator cartLink;
    private final Locator productInCart;
    private final Locator checkoutButton;

    public ProductPage(Page page) {
        this.title = page.locator(".title");
        this.addBackpackButton = page.locator("#add-to-cart-sauce-labs-backpack");
        this.cartBadge = page.locator("[data-test='shopping-cart-badge']");
        this.cartLink = page.locator("[data-test='shopping-cart-link']");
        this.productInCart = page.locator("[data-test='inventory-item-name']");
        this.checkoutButton = page.locator("[data-test='checkout']");
    }

    public void verifyProductsPage() {
        assertThat(title).hasText("Products");
    }

    public void addProductToCart() {
        addBackpackButton.click();
    }

    public void verifyProductInCart() {
        assertThat(cartBadge).hasText("1");
    }

    public void openCart() {
        cartLink.click();
    }

    public void verifyProductInCartPage() {
        assertThat(productInCart).hasText("Sauce Labs Backpack");
    }

    public void startCheckout() {
        checkoutButton.click();
    }

}