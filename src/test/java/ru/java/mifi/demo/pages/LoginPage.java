package ru.java.mifi.demo.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class LoginPage {
    private final Page page;
    private final Locator signUp;
    private final Locator usernameField;
    private final Locator passwordField;
    private final Locator login;
    private final Locator logout;
    private final Locator nameOfUser;


    // Конструктор принимает объект Page
    public LoginPage(Page page) {
        this.page = page;
        this.signUp = page.locator("#login2");
        this.usernameField = page.locator("#loginusername");
        this.passwordField = page.locator("#loginpassword");;
        this.login = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in"));
        this.logout = page.locator("#logout2");;
        this.nameOfUser = page.locator("#nameofuser");;
    }

    // Метод навигации на главную страницу демоблейза
    public void navigateToHomepage() {
        page.navigate("https://www.demoblaze.com/index.html");
    }

    // Проверочный элемент "login" после успешного входа
    public void checkLogin(String username) {
        nameOfUser.getByText(username);
    }

    // Метод для заполнения формы и отправки её
    public void performLogin(String username, String password) {
        signUp.click(); // Нажатие на ссылку Sign Up / Log In
        usernameField.fill(username);
        passwordField.fill(password);
        login.click();
        logout.waitFor();      // Ждем появления Logout ссылки
    }

    // Метод для заполнения формы и отправки её
    public void performLogout() {
        logout.click();
        login.waitFor();
    }

    // Сделаем скриншот страницы
    public void takeScreenshot(String filePath) {
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(filePath)));
    }
}