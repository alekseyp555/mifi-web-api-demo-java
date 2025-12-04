package ru.java.mifi.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrderCardTest {
    private WebDriver driver;

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    public void shouldSearchWiki() {
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).sendKeys("playwright");
        driver.findElement(By.name("search")).sendKeys(Keys.ENTER);

        // Проверяем, соответствует ли адрес страницы ожидаемому адресу
        String expectedUrl = "https://www.wikipedia.org/";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}