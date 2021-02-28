package com.example.taco.controllers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.example.taco.constants.URL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@SpringBootTest
@AutoConfigureMockMvc
class BasketControllerTest {
    @Autowired
    private WebDriver webDriver;

    @BeforeEach
    public void setup() {
        WebDriverRunner.setWebDriver(webDriver);
    }

    @Test
    void shouldSeeMessageIfThereIsNoItems() {
        open("http://localhost" + URL.BASKET);

        $("h1").shouldHave(Condition.text("Nothing here"));
    }

    @Test
    void shouldDisplayListOfItems() {
        open("http://localhost" + URL.HOME);

        $$(".card .card-body .card-title a").findBy(text("All Butter Croissant")).closest(".card").find(".card-footer .btn").click();
        $$(".card .card-body .card-title a").findBy(text("All Butter Croissant")).closest(".card").find(".card-footer .btn").click();
        $$(".card .card-body .card-title a").findBy(text("Fresh Baguette")).closest(".card").find(".card-footer .btn").click();

        $$(".navbar a.nav-link").findBy(attribute("href", "http://localhost" + URL.BASKET)).click();

        $$("h1").findBy(Condition.text("Nothing here")).shouldNot(exist);

        $("h1").shouldHave(Condition.text("Your Basket"));

        $$("td").findBy(text("All Butter Croissant")).should(exist);
        $$("td").findBy(text("All Butter Croissant")).closest("tr").findAll("td").findBy(text("2")).should(exist);
        $$("td").findBy(text("Fresh Baguette")).should(exist);

        $$("td").findBy(text("All Butter Croissant")).closest("tr").find("button").click();
        $$("td").findBy(text("All Butter Croissant")).closest("tr").findAll("td").findBy(text("1")).should(exist);

        $$("td").findBy(text("All Butter Croissant")).closest("tr").find("button").click();
        $$("td").findBy(text("All Butter Croissant")).shouldNot(exist);
    }
}