package com.example.taco.views;

import com.example.taco.annotations.View;

import java.util.Arrays;

import static j2html.TagCreator.*;

@View
public class HomePageView implements SimpleView {
    @Override
    public String render() {
        return document(
                html(
                        head(
                                meta().withCharset("utf-8"),
                                meta().withName("viewport").withContent("width=device-width, initial-scale=1, shrink-to-fit=no"),
                                title("Home - Taco Factory"),
                                link().withRel("stylesheet").withHref("/vendor/bootstrap/css/bootstrap.min.css"),
                                link().withRel("stylesheet").withHref("/css/shop-homepage.css")
                        ),
                        body(
                                nav().withClass("navbar navbar-expand-lg navbar-dark bg-dark fixed-top").with(
                                        div().withClass("container").with(
                                                a("Taco Factory").withClass("navbar-brand").withHref("/")
                                        )
                                ),

                                div().withClass("container").with(
                                        div().withClass("row").with(
                                                div().withClass("col-lg-3").with(
                                                        h1("Taco Factory").withClass("my-4"),
                                                        div().withClass("list-group").with(
                                                                a("Category 1").withClass("list-group-item").withHref("#"),
                                                                a("Category 2").withClass("list-group-item").withHref("#"),
                                                                a("Category 3").withClass("list-group-item").withHref("#")
                                                        )
                                                ),
                                                div().withClass("col-lg-9").with(
                                                        div().withId("carouselExampleIndicators").withClass("carousel slide my-4").attr("data-ride", "carousel").with(
                                                                ol().withClass("carousel-indicators").with(
                                                                        li().attr("data-target", "#carouselExampleIndicators").attr("data-slide-to", "0").withClass("active"),
                                                                        li().attr("data-target", "#carouselExampleIndicators").attr("data-slide-to", "1"),
                                                                        li().attr("data-target", "#carouselExampleIndicators").attr("data-slide-to", "2")
                                                                ),
                                                                div().withClass("carousel-inner").withRole("listbox").with(
                                                                        div().withClass("carousel-item active").with(
                                                                                img().withClass("d-block img-fluid").withAlt("First slide").withSrc("http://placehold.it/900x350")
                                                                        ),
                                                                        div().withClass("carousel-item").with(
                                                                                img().withClass("d-block img-fluid").withAlt("Second slide").withSrc("http://placehold.it/900x350")
                                                                        ),
                                                                        div().withClass("carousel-item").with(
                                                                                img().withClass("d-block img-fluid").withAlt("Third slide").withSrc("http://placehold.it/900x350")
                                                                        )
                                                                ),
                                                                a().withClass("carousel-control-prev").attr("data-slide", "prev").withHref("#carouselExampleIndicators").withRole("button").with(
                                                                        span().withClass("carousel-control-prev-icon").attr("aria-hidden", "true"),
                                                                        span("Previous").withClass("sr-only")
                                                                ),
                                                                a().withClass("carousel-control-next").attr("data-slide", "next").withHref("#carouselExampleIndicators").withRole("button").with(
                                                                        span().withClass("carousel-control-next-icon").attr("aria-hidden", "true"),
                                                                        span("Next").withClass("sr-only")
                                                                )
                                                        ),
                                                        div().withClass("row").with(
                                                                each(Arrays.asList("Item One", "Item Two", "Item Three", "Item Four", "Item Five", "Item Six"), name -> div().withClass("col-lg-4 col-md-6 mb-4").with(
                                                                        div().withClass("card h-100").with(
                                                                                a().withHref("#").with(
                                                                                        img().withClass("card-img-top").withAlt("").withSrc("http://placehold.it/700x400")
                                                                                ),
                                                                                div().withClass("card-body").with(
                                                                                        h4().withClass("card-title").with(
                                                                                                a(name).withHref("#")
                                                                                        ),
                                                                                        h5("$24.99"),
                                                                                        p("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!").withClass("card-text")

                                                                                ),
                                                                                div().withClass("card-footer").with(
                                                                                        small("⭐ ⭐ ⭐ ⭐ ⭐").withClass("text-muted")
                                                                                )
                                                                        )
                                                                ))
                                                        )
                                                )
                                        )
                                ),

                                footer().withClass("py-5 bg-dark").with(
                                        div().withClass("container").with(
                                                p("Copyright © Taco Factory 2021").withClass("m-0 text-center text-white")
                                        )
                                ),

                                script().withSrc("/vendor/jquery/jquery.min.js"),
                                script().withSrc("/vendor/bootstrap/js/bootstrap.bundle.min.js")
                        )
                )
        );
    }
}
