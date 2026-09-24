package com.mts.steps;

import com.microsoft.playwright.Page;
import com.mts.pages.CheckoutOverviewPage;
import com.mts.pages.CheckoutPage;
import com.mts.pages.CompletePage;
import com.mts.pages.LoginPage;
import com.mts.pages.ProductPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {

    private final Page page;
    private final LoginPage loginPage;
    private final ProductPage productPage;
    private final CheckoutPage checkoutPage;
    private final CheckoutOverviewPage checkoutOverviewPage;
    private final CompletePage completePage;

    public ProductSteps() {
        this.page = com.mts.support.CucumberHooks.getPage();
        this.loginPage = new LoginPage(page);
        this.productPage = new ProductPage(page);
        this.checkoutPage = new CheckoutPage(page);
        this.checkoutOverviewPage = new CheckoutOverviewPage(page);
        this.completePage = new CompletePage(page);
    }

    @Given("el usuario inicia sesión con {string} y {string}")
    public void login(String username, String password) {
        loginPage.navigate();
        loginPage.login(username, password);
    }

    @When("agrega un producto al carrito")
    public void addProductToCart() {
        productPage.addProductToCart();

    }

    @Then("el producto debería aparecer en el carrito")
    public void verifyProductInCart() {
        productPage.verifyProductInCart();

    }

    @When("ingresa al carrito")
    public void openCart() {
        productPage.openCart();

    }

    @Then("debería visualizar el producto en el carrito")
    public void verifyProductInCartPage() {
        productPage.verifyProductInCartPage();

    }

    @When("inicia el proceso de checkout")
    public void startCheckout() {
        productPage.startCheckout();
    }

    @When("completa la información de compra")
    public void fillCheckoutInformation() {
        checkoutPage.fillInformation("TestNombre", "TestApellido", "15494");
    }

    @When("continúa con el checkout")
    public void continueCheckout() {
        checkoutPage.continueCheckout();
    }

    @When("finaliza la compra")
    public void finishPurchase() {
        checkoutOverviewPage.finishPurchase();
    }

    @Then("debería visualizar la confirmación de compra")
    public void verifyPurchaseCompleted() {
        completePage.verifyPurchaseCompleted();
    }
}
