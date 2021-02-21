package com.example.taco.views.components;

import com.example.taco.views.models.HomePageViewModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static j2html.TagCreator.h1;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LayoutTest {
    @Autowired
    private Layout layout;

    @Test
    void shouldRenderSimpleContent() {
        String html = layout.simple(new HomePageViewModel(), h1("hello"));
        assertThat(html).contains("hello");
    }

    @Test
    void shouldRenderSimpleContentWithSidebar() {
        String html = layout.leftSidebar(new HomePageViewModel(), h1("sidebar"), h1("hello"));
        assertThat(html).contains("sidebar").contains("hello");
    }
}