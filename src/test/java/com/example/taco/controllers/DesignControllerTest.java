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
}