package ru.java.mifi.demo;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckRestTest {
    @Test
    public void testLogin() {
        // Запрос на login API
        Response response = given()
                .log().all()                   // Логирование запросов
                .baseUri("https://api.demoblaze.com")
                .headers(
                        "Content-Type", "application/json"
                )
                .body("{\"username\":\"test\",\"password\":\"dGVzdA==\"}")
                .when()
                .post("/login")
                        .then()
                                .statusCode(200)
                                        .extract().response();
        assertEquals(200, response.statusCode());
    }

    @Test
    public void testCheck() {
        // Запрос на check API
        Response response = given()
                .log().all()                   // Логирование запросов
                .baseUri("https://api.demoblaze.com")
                .headers(
                        "Content-Type", "application/json"
                )
                .body("{\"token\":\"dGVzdDE3NjU1NDA=\"}")
                .when()
                .post("/check")
                .then()
                .statusCode(200)
                .extract().response();
        assertEquals(200, response.statusCode());
    }
}