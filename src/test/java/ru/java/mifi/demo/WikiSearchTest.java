package ru.java.mifi.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WikiSearchTest {

    @BeforeAll
    public void beforeAll() {
        Configuration.browser = "chrome"; // используем браузер Chrome
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
        $("#firstHeading").shouldHave(text("Playwright"));
    }

//    @AfterEach
//    public void afterEach() {
//        Selenide.closeWindow();       // закрываем окно браузера после каждого теста
//    }
}