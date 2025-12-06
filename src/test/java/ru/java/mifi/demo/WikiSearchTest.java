package ru.java.mifi.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WikiSearchTest {

    @BeforeAll
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true) // Enable screenshots on failure
                .savePageSource(true)); // Save page source on failure
    }

    @BeforeAll
    public void beforeAll() {
        Configuration.browser = "chrome"; // используем браузер Chrome
    }

    @AfterAll
    static void tearDownAllureReports() {
        SelenideLogger.removeListener("AllureSelenide");
    }

    @BeforeEach
    public void setUp() {
        open("https://www.wikipedia.org/"); // открываем главную страницу Википедии
    }

    @Test
    public void shouldSearchWiki() {
        $(byName("search"))           // находим поле поиска по имени input'a
                .val("playwright")    // вводим значение "playwright"
                .pressEnter();          // нажимаем Enter для начала поиска

        // проверяем, что заголовок страницы содержит слово "Playwright"
        $("#firstHeading").shouldHave(text("Результаты поиска"));
        webdriver().shouldHave(url("https://ru.wikipedia.org/w/index.php?go=Go&search=playwright&title=%D0%A1%D0%BB%D1%83%D0%B6%D0%B5%D0%B1%D0%BD%D0%B0%D1%8F:%D0%9F%D0%BE%D0%B8%D1%81%D0%BA&ns0=1"));
    }

//    @AfterEach
//    public void afterEach() {
//        Selenide.closeWindow();       // закрываем окно браузера после каждого теста
//    }
}