package com.example.taco.views;

import com.example.taco.annotations.View;

import static j2html.TagCreator.*;

@View
public class DesignPageView implements SimpleView {
    @Override
    public String render() {
        return document(
                html(
                        head(
                                meta().withCharset("utf-8"),
                                meta().withName("viewport").withContent("width=device-width, initial-scale=1, shrink-to-fit=no"),
                                title("Design - Taco Factory"),
                                link().withRel("stylesheet").withHref("/vendor/bootstrap/css/bootstrap.min.css"),
                                link().withRel("stylesheet").withHref("/css/shop-homepage.css")
                        ),
                        body(
                                nav().withClass("navbar navbar-expand-lg navbar-dark bg-dark fixed-top").with(
                                        div().withClass("container").with(
                                                a("Taco Factory").withClass("navbar-brand").withHref("/")
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
