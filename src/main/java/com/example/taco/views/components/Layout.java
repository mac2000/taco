package com.example.taco.views.components;

import com.example.taco.views.models.interfaces.WithHeadTitle;
import j2html.tags.ContainerTag;

import static com.example.taco.views.components.atoms.Bootstrap.container;
import static j2html.TagCreator.*;

public class Layout {
    public static ContainerTag head(WithHeadTitle withHeadTitle) {
        return j2html.TagCreator.head(
                meta().withCharset("utf-8"),
                meta().withName("viewport").withContent("width=device-width, initial-scale=1, shrink-to-fit=no"),
                title(withHeadTitle.getHeadTitle()),
                link().withRel("stylesheet").withHref("/vendor/bootstrap/css/bootstrap.min.css"),
                link().withRel("stylesheet").withHref("/css/shop-homepage.css")
        );
    }

    public static ContainerTag footer() {
        return j2html.TagCreator.footer().withClass("py-5 bg-dark").with(
                container(
                        p("Copyright © Taco Factory 2021").withClass("m-0 text-center text-white")
                )
        );
    }
}
