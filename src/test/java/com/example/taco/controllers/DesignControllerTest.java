package com.example.taco.controllers;

import com.example.taco.constants.URL;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DesignControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldRenderDesignPage() throws Exception {
        mockMvc.perform(get(URL.DESIGN))
                .andExpect(status().isOk());
    }

    @Test
    void shouldHaveMetaCharset() throws Exception {
        mockMvc.perform(get(URL.DESIGN))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<meta charset=\"utf-8\">")));
    }

    @Test
    void shouldHaveMetaViewport() throws Exception {
        mockMvc.perform(get(URL.DESIGN))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">")));
    }

    @Test
    void shouldHaveHeadTitle() throws Exception {
        mockMvc.perform(get(URL.DESIGN))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<title>Design - Taco Factory</title>")));
    }

    @Test
    void shouldHaveStylesConnected() throws Exception {
        mockMvc.perform(get(URL.DESIGN))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<link rel=\"stylesheet\" href=\"/vendor/bootstrap/css/bootstrap.min.css\">")))
                .andExpect(content().string(containsString("<link rel=\"stylesheet\" href=\"/css/shop-homepage.css\">")));
    }

    @Test
    void shouldHaveScriptsConnected() throws Exception {
        mockMvc.perform(get(URL.DESIGN))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<script src=\"/vendor/jquery/jquery.min.js\"></script>")))
                .andExpect(content().string(containsString("<script src=\"/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>")));
    }

    @Test
    void shouldHaveHeader() throws Exception {
        mockMvc.perform(get(URL.DESIGN))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark fixed-top\">")))
                .andExpect(content().string(containsString("<a class=\"navbar-brand\" href=\"/\">Taco Factory</a>")))
                .andExpect(content().string(containsString("</nav>")));
    }

    @Test
    void shouldHaveFooter() throws Exception {
        mockMvc.perform(get(URL.DESIGN))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<footer class=\"py-5 bg-dark\">")))
                .andExpect(content().string(containsString("Copyright © Taco Factory 2021")))
                .andExpect(content().string(containsString("</footer>")));
    }

    @Test
    void shouldHaveHeaderMenu() throws Exception {
        mockMvc.perform(get(URL.DESIGN))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<a class=\"nav-link\" href=\"/\">Home")))
                .andExpect(content().string(containsString("<a class=\"nav-link\" href=\"/design\">Design")));
    }

    @Test
    void shouldHaveHeaderMenuActiveItem() throws Exception {
        mockMvc.perform(get(URL.DESIGN))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<li class=\"nav-item active\"><a class=\"nav-link\" href=\"/design\">Design")));
    }

    @Test
    void shouldHaveForm() throws Exception {
        mockMvc.perform(get(URL.DESIGN))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<form method=\"post\">")))
                .andExpect(content().string(containsString("<div id=\"wraps\" class=\"ingredient-group\">")))
                .andExpect(content().string(containsString("<h3>Designate your wrap:</h3>")))
                .andExpect(content().string(containsString("<input name=\"ingredients\" type=\"checkbox\" value=\"FLTO\">")))
                .andExpect(content().string(containsString("<input name=\"ingredients\" type=\"checkbox\" value=\"COTO\">")))
                .andExpect(content().string(containsString("<div id=\"proteins\" class=\"ingredient-group\">")))
                .andExpect(content().string(containsString("<h3>Pick your protein:</h3>")))
                .andExpect(content().string(containsString("<input name=\"ingredients\" type=\"checkbox\" value=\"GRBF\">")))
                .andExpect(content().string(containsString("<input name=\"ingredients\" type=\"checkbox\" value=\"CARN\">")))
                .andExpect(content().string(containsString("<div id=\"cheeses\" class=\"ingredient-group\">")))
                .andExpect(content().string(containsString("<h3>Choose your cheese:</h3>")))
                .andExpect(content().string(containsString("<input name=\"ingredients\" type=\"checkbox\" value=\"CHED\">")))
                .andExpect(content().string(containsString("<input name=\"ingredients\" type=\"checkbox\" value=\"JACK\">")))
                .andExpect(content().string(containsString("<div id=\"veggies\" class=\"ingredient-group\">")))
                .andExpect(content().string(containsString("<h3>Determine your veggies:</h3>")))
                .andExpect(content().string(containsString("<input name=\"ingredients\" type=\"checkbox\" value=\"TMTO\">")))
                .andExpect(content().string(containsString("<input name=\"ingredients\" type=\"checkbox\" value=\"LETC\">")))
                .andExpect(content().string(containsString("<div id=\"sauces\" class=\"ingredient-group\">")))
                .andExpect(content().string(containsString("<h3>Select your sauce:</h3>")))
                .andExpect(content().string(containsString("<input name=\"ingredients\" type=\"checkbox\" value=\"SLSA\">")))
                .andExpect(content().string(containsString("<input name=\"ingredients\" type=\"checkbox\" value=\"SRCR\">")))
                .andExpect(content().string(containsString("<h3>Name your taco creation:</h3>")))
                .andExpect(content().string(containsString("<input name=\"name\" type=\"text\">")))
                .andExpect(content().string(containsString("<button>Submit your taco</button>")));
    }
}