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
}