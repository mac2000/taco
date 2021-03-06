package com.example.taco.views.components;

import com.example.taco.annotations.View;
import com.example.taco.constants.URL;
import com.example.taco.views.models.interfaces.LayoutData;
import com.example.taco.views.models.interfaces.WithCurrentUrl;
import com.example.taco.views.models.interfaces.WithHeadTitle;
import j2html.tags.ContainerTag;
import lombok.extern.slf4j.Slf4j;

import static com.example.taco.views.components.atoms.Bootstrap.container;
import static com.example.taco.views.components.atoms.Bootstrap.row;
import static j2html.TagCreator.*;

@View
@Slf4j
public class Layout {
    private static String layout(LayoutData model, ContainerTag content) {
        return document(
                html(
                        Layout.head(model),
                        body(
                                Layout.header(model),
                                container(content),
                                Layout.footer(),
                                script().withSrc("/vendor/jquery/jquery.min.js"),
                                script().withSrc("/vendor/bootstrap/js/bootstrap.bundle.min.js")
                        )
                )
        );
    }

    public String simple(LayoutData model, ContainerTag content) {
        return layout(model, content);
    }

    public String leftSidebar(LayoutData model, ContainerTag sidebar, ContainerTag content) {
        return simple(model, row(
                div().withClass("col-lg-3").with(sidebar),
                div().withClass("col-lg-9").with(content)
        ));
    }

    private static ContainerTag head(WithHeadTitle withHeadTitle) {
        return j2html.TagCreator.head(
                meta().withCharset("utf-8"),
                meta().withName("viewport").withContent("width=device-width, initial-scale=1, shrink-to-fit=no"),
                title(withHeadTitle.getHeadTitle()),
                link().withRel("stylesheet").withHref("/vendor/bootstrap/css/bootstrap.min.css"),
                link().withRel("stylesheet").withHref("/css/shop-homepage.css")
        );
    }

    private static ContainerTag header(LayoutData model) {
        log.info("building header for {} == {}", model.getCurrentUrl(), URL.HOME);
        return nav().withClass("navbar navbar-expand-lg navbar-dark bg-dark fixed-top").with(
                container(
                        a("Taco Factory").withClass("navbar-brand").withHref(URL.HOME),
                        button().withClass("navbar-toggler").withType("button").attr("data-toggle", "collapse").attr("data-target", "#navbarResponsive").attr("aria-controls", "navbarResponsive").attr("aria-expanded", "false").attr("aria-label", "Toggle navigation").with(
                                span().withClass("navbar-toggler-icon")
                        ),
                        div().withId("navbarResponsive").withClass("collapse navbar-collapse").with(
                                ul().withClass("navbar-nav ml-auto").with(
                                        iff(model.getNumberOfBasketItems() > 0,
                                                navItem(model, URL.BASKET, "Basket: " + model.getNumberOfBasketItems() + " item(s)")
                                        ),
                                        navItem(model, URL.HOME, "Home"),
                                        navItem(model, URL.DESIGN, "Design")
                                )
                        )
                )
        );
    }

    private static ContainerTag navItem(WithCurrentUrl withCurrentUrl, String url, String title) {
        return li().withClasses("nav-item", iff(withCurrentUrl.getCurrentUrl().equals(url), "active")).with(
                a(title).withClass("nav-link").withHref(url)
        );
    }

    private static ContainerTag footer() {
        return j2html.TagCreator.footer().withClass("py-5 bg-dark").with(
                container(
                        p("Copyright © Taco Factory 2021").withClass("m-0 text-center text-white")
                )
        );
    }
}
