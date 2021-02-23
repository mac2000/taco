package com.example.taco.controllers;

import com.codeborne.selenide.WebDriverRunner;
import com.example.taco.constants.URL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@SpringBootTest
@AutoConfigureMockMvc
class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebDriver webDriver;

    //@MockBean
    //private TacoService tacoService;

    @BeforeEach
    public void setup() {
        WebDriverRunner.setWebDriver(webDriver);
    }

    @Test
    void shouldRenderHomePage() {
        /*when(tacoService.findAll()).thenReturn(List.of(
                Taco.builder().id("abcr").name("All Butter Croissant").price(75).build(),
                Taco.builder().id("ccr").name("Chocolate Croissant").price(95).build(),
                Taco.builder().id("b").name("Fresh Baguette").price(160).build(),
                Taco.builder().id("rv").name("Red Velvet").price(395).build(),
                Taco.builder().id("vs").name("Victoria Sponge").price(545).build(),
                Taco.builder().id("cc").name("Carrot Cake").price(345).build()
        ));*/

        open("http://localhost/");

        $$("meta").find(attribute("charset", "utf-8")).should(exist);
        $$("meta").find(attribute("name", "viewport")).shouldHave(attribute("content", "width=device-width, initial-scale=1, shrink-to-fit=no"));
        $$("link").filter(attribute("rel", "stylesheet")).find(attribute("href", "http://localhost/vendor/bootstrap/css/bootstrap.min.css")).should(exist);
        $$("link").filter(attribute("rel", "stylesheet")).find(attribute("href", "http://localhost/css/shop-homepage.css")).should(exist);
        $$("script").find(attribute("src", "http://localhost/vendor/jquery/jquery.min.js")).should(exist);
        $$("script").find(attribute("src", "http://localhost/vendor/bootstrap/js/bootstrap.bundle.min.js")).should(exist);
        $(".navbar .navbar-brand").shouldHave(text("Taco Factory"));
        $("footer").shouldHave(text("Copyright © Taco Factory 2021"));
        $("h1").shouldHave(text("Taco Factory"));

        $$("a.list-group-item").findBy(text("Category 1")).should(exist);
        $$("a.list-group-item").findBy(text("Category 2")).should(exist);
        $$("a.list-group-item").findBy(text("Category 3")).should(exist);

        $$(".card .card-body .card-title a").findBy(text("All Butter Croissant")).should(exist);
        $$(".card .card-body .card-title a").findBy(text("Chocolate Croissant")).should(exist);
        $$(".card .card-body .card-title a").findBy(text("Fresh Baguette")).should(exist);
        $$(".card .card-body .card-title a").findBy(text("Red Velvet")).should(exist);
        $$(".card .card-body .card-title a").findBy(text("Victoria Sponge")).should(exist);
        $$(".card .card-body .card-title a").findBy(text("Carrot Cake")).should(exist);

        $("#carouselExampleIndicators").should(exist);
        $$("#carouselExampleIndicators img").findBy(attribute("alt", "First slide")).should(exist);
        $$("#carouselExampleIndicators img").findBy(attribute("alt", "Second slide")).should(exist);
        $$("#carouselExampleIndicators img").findBy(attribute("alt", "Third slide")).should(exist);

        $$(".navbar a.nav-link").filterBy(attribute("href", "http://localhost" + URL.HOME)).findBy(text("Home")).should(exist);
        $$(".navbar a.nav-link").filterBy(attribute("href", "http://localhost" + URL.DESIGN)).findBy(text("Design")).should(exist);

        $(".navbar .nav-item.active a.nav-link").shouldHave(text("Home"));
    }
}