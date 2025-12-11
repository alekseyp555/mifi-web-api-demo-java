package ru.java.mifi.demo;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;

public class TestPwExample {
    // Shared between all tests in this class.
    static Playwright playwright;
    static Browser browser;

    // New instance for each test method.
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @Test
    void loginTest() {
        page.navigate("https://www.demoblaze.com/index.html");
        page.locator("#login2").click();
        page.locator("#loginusername").fill("test");
        page.locator("#loginpassword").fill("test");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();
        page.locator("#logout2").waitFor();
        page.locator("#nameofuser").getByText("Welcome test");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("demoblaze.png")));
    }

    @Test
    void logOutTest() {
        page.navigate("https://www.demoblaze.com/index.html");
        page.locator("#login2").click();
        page.locator("#loginusername").fill("test");
        page.locator("#loginpassword").fill("test");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in")).click();
        page.locator("#logout2").waitFor();
        page.locator("#logout2").click();
        page.locator("#login2").waitFor();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("demoblaze2.png")));
    }
}