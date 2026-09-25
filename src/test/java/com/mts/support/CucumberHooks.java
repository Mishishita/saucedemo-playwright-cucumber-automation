package com.mts.support;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks {

    protected static Playwright playwright;
    protected static Browser browser;
    protected static BrowserContext context;
    protected static Page page;

    @Before
    public void setUp() {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        // Para que se un poco lenta y pueda ver las acciones
        // browser = playwright.chromium().launch(new
        // BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));

        context = browser.newContext();

        page = context.newPage();
    }

    @After
    public void tearDown(Scenario scenario) {

        byte[] screenshot = page.screenshot(
                new Page.ScreenshotOptions()
                        .setFullPage(true));

        scenario.attach(
                screenshot,
                "image/png",
                scenario.getName());

        context.close();
        browser.close();
        playwright.close();
    }

    public static Page getPage() {
        return page;
    }

}
