package com.mts.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

public class LoginPage {

    private final Page page;
    // Elementos
    private final Locator errorMessage;
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;

    public LoginPage(Page page) {
        this.page = page;
        this.usernameInput = page.locator("#user-name");
        this.passwordInput = page.locator("#password");
        this.loginButton = page.locator("#login-button");
        this.errorMessage = page.locator("[data-test='error']");
    }

    public void navigate() {
        page.navigate("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        usernameInput.fill(username);
        passwordInput.fill(password);
        loginButton.click();
    }

    public void verifyLockedOutMessage() {
        assertThat(errorMessage).hasText("Epic sadface: Sorry, this user has been locked out.");
    }

}
