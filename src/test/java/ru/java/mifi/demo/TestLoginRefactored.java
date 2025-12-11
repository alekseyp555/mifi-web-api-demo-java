package ru.java.mifi.demo;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import ru.java.mifi.demo.pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLoginRefactored {
    static Playwright playwright;
    static Browser browser;

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
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToHomepage();
        loginPage.performLogin("test", "test"); // Выполняем вход
        assertTrue(loginPage.logoutLink().isVisible()); // Убеждаемся, что появилась ссылка выхода
        loginPage.takeScreenshot("demoblaze.png");
    }

    @Test
    void logOutTest() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToHomepage();
        loginPage.performLogin("test", "test"); // Выполняем вход
        page.locator("#logout2").click();
        page.locator("#login2").waitFor();
        loginPage.takeScreenshot("demoblaze2.png");
    }
}