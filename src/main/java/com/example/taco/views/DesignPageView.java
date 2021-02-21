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
                                meta().withCharset("utf-8")
                        )
                )
        );
    }
}
