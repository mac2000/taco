package com.example.taco.views;

import com.example.taco.annotations.View;
import com.example.taco.constants.URL;
import com.example.taco.views.components.Layout;
import com.example.taco.views.models.HomePageViewModel;

import java.util.Arrays;

import static com.example.taco.views.components.atoms.Bootstrap.container;
import static com.example.taco.views.components.atoms.Bootstrap.row;
import static j2html.TagCreator.*;

@View
public class HomePageView implements GenericView<HomePageViewModel> {
    @Override
    public String render(HomePageViewModel model) {
        return document(
                html(
                        Layout.head(model),
                        body(
                                nav().withClass("navbar navbar-expand-lg navbar-dark bg-dark fixed-top").with(
                                        container(
                                                a("Taco Factory").withClass("navbar-brand").withHref(URL.HOME)
                                        )
                                ),

                                container(
                                        row(
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
                                                        row(
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

                                Layout.footer(),

                                script().withSrc("/vendor/jquery/jquery.min.js"),
                                script().withSrc("/vendor/bootstrap/js/bootstrap.bundle.min.js")
                        )
                )
        );
    }
}
