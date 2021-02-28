package com.example.taco.views.components;

import com.example.taco.annotations.View;
import j2html.tags.ContainerTag;

import static j2html.TagCreator.*;

@View
public class Carousel {

    private static final String PLACEHOLDER = "http://placehold.it/900x350";
    private static final String ID = "carouselExampleIndicators";
    private static final String SELECTOR = "#" + ID;

    public ContainerTag carousel() {
        return div().withId(ID).withClass("carousel slide my-4").attr("data-ride", "carousel").with(
                ol().withClass("carousel-indicators").with(
                        carouselIndicator("0").withClass("active"),
                        carouselIndicator("1"),
                        carouselIndicator("2")
                ),
                div().withClass("carousel-inner").withRole("listbox").with(
                        carouselItem(true, "First slide", PLACEHOLDER),
                        carouselItem(false, "Second slide", PLACEHOLDER),
                        carouselItem(false, "Third slide", PLACEHOLDER)
                ),
                navButton("Previous", "prev"),
                navButton("Next", "next")
        );
    }

    private ContainerTag navButton(String title, String css) {
        return a().withClass("carousel-control-" + css).attr("data-slide", css).withHref(SELECTOR).withRole("button").with(
                span().withClass("carousel-control-" + css + "-icon").attr("aria-hidden", "true"),
                span(title).withClass("sr-only")
        );
    }

    private ContainerTag carouselItem(boolean active, String alt, String src) {
        return div().withClass(active ? "carousel-item active" : "carousel-item").with(
                img().withClass("d-block img-fluid").withAlt(alt).withSrc(src)
        );
    }

    private ContainerTag carouselIndicator(String value) {
        return li().attr("data-target", SELECTOR).attr("data-slide-to", value);
    }
}
