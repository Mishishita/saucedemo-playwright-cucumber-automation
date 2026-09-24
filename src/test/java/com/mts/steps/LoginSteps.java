package com.mts.steps;

import com.microsoft.playwright.Page;
import com.mts.pages.LoginPage;
import com.mts.pages.ProductPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    private final Page page;
    private final LoginPage loginPage;
    private final ProductPage productPage;

    public LoginSteps() {
        this.page = com.mts.support.CucumberHooks.getPage();
        this.loginPage = new LoginPage(page);
        this.productPage = new ProductPage(page);
    }

    @Given("el usuario se encuentra en la página de login de Sauce Demo")
    public void loginPage() {
        loginPage.navigate();
    }

    @When("inicia sesión con el usuario {string} y contraseña {string}")
    public void loginSession(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("debería acceder a la página de productos")
    public void verifyProductPage() {
        productPage.verifyProductsPage();
    }

    @Then("debería visualizar un mensaje de usuario bloqueado")
    public void verifyLockedOutMessage() {
        loginPage.verifyLockedOutMessage();
    }

}
