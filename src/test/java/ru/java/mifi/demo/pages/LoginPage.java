package ru.java.mifi.demo.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class LoginPage {
    private final Page page;

    // Конструктор принимает объект Page
    public LoginPage(Page page) {
        this.page = page;
    }

    // Метод навигации на главную страницу демоблейза
    public void navigateToHomepage() {
        page.navigate("https://www.demoblaze.com/index.html");
    }

    // Элемент "Sign up / Log in" ссылка
    Locator signUpOrLogInLink() {
        return page.locator("#login2");
    }

    // Логин-поле ввода
    Locator usernameField() {
        return page.locator("#loginusername");
    }

    // Пароль-поле ввода
    Locator passwordField() {
        return page.locator("#loginpassword");
    }

    // Кнопка "Log in"
    Locator logInButton() {
        return page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in"));
    }

    // Проверочный элемент "Logout" после успешного входа
    public Locator logoutLink() {
        return page.locator("#logout2");
    }

    // Метод для заполнения формы и отправки её
    public void performLogin(String username, String password) {
        signUpOrLogInLink().click(); // Нажатие на ссылку Sign Up / Log In
        usernameField().fill(username);
        passwordField().fill(password);
        logInButton().click();
        logoutLink().waitFor();      // Ждем появления Logout ссылки
    }

    // Сделаем скриншот страницы
    public void takeScreenshot(String filePath) {
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(filePath)));
    }
}