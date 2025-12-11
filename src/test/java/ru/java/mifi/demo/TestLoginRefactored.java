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
        loginPage.checkLogin("test"); // Убеждаемся, что появилось имя пользователя
        loginPage.takeScreenshot("demoblaze.png");
    }

    @Test
    void logOutTest() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigateToHomepage();
        loginPage.performLogin("test", "test"); // Выполняем вход
        loginPage.performLogout();
        loginPage.takeScreenshot("demoblaze2.png");
    }
}