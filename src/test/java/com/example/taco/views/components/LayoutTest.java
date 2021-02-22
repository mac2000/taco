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
        shouldHaveBasicLayout(html);
    }

    @Test
    void shouldRenderSimpleContentWithSidebar() {
        String html = layout.leftSidebar(new HomePageViewModel(), h1("sidebar"), h1("hello"));
        assertThat(html).contains("sidebar").contains("hello");
        shouldHaveBasicLayout(html);
    }

    private void shouldHaveBasicLayout(String html) {
        assertThat(html).contains("<meta charset=\"utf-8\">");
        assertThat(html).contains("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
        assertThat(html).contains("<title>Home - Taco Factory</title>");
        assertThat(html).contains("<link rel=\"stylesheet\" href=\"/vendor/bootstrap/css/bootstrap.min.css\">");
        assertThat(html).contains("<link rel=\"stylesheet\" href=\"/css/shop-homepage.css\">");
        assertThat(html).contains("<script src=\"/vendor/jquery/jquery.min.js\"></script>");
        assertThat(html).contains("<script src=\"/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>");
        assertThat(html).contains("Copyright © Taco Factory 2021");
        assertThat(html).contains("<a class=\"navbar-brand\" href=\"/\">Taco Factory</a>");
        assertThat(html).contains("<a class=\"nav-link\" href=\"/\">Home");
        assertThat(html).contains("<a class=\"nav-link\" href=\"/design\">Design");
        assertThat(html).contains("<li class=\"nav-item active\"><a class=\"nav-link\" href=\"/\">Home");
    }
}