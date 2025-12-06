package ru.java.mifi.demo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckRestTest {

    @Test
    void testHealthCheck() {
        // Given — When — Then
        // Предусловия
        given()
                .baseUri("https://restful-booker.herokuapp.com")
        // Выполняемые действия
                .when()
                .get("/ping")
        // Проверки
                .then()
                .statusCode(201)
        ;
    }

    @Test
    void testGetBooking() {
        // Given — When — Then
        // Предусловия
        given()
                .baseUri("https://restful-booker.herokuapp.com")
                // Выполняемые действия
                .when()
                    .get("/booking/1")
                // Проверки
                .then()
                    .statusCode(200)
                    .body("firstname", equalTo("Mary"))
                    .body("lastname", equalTo("Smith"))
                    .body("totalprice", equalTo(657))
                    .body("depositpaid", equalTo(false))
                    .body("bookingdates.checkin", equalTo("2020-12-12"))
                    .body("bookingdates.checkout", equalTo("2024-01-06"));
    }

    @Test
    void testGetBookingAll() {
        // Given — When — Then
        // Предусловия
        given()
                .baseUri("https://restful-booker.herokuapp.com")
                // Выполняемые действия
                .when()
                    .get("/booking")
                // Проверки
                .then()
                    .statusCode(200)
                .body("every{ it.bookingid >=0 }", is(true));
        ;
    }

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