package com.example.taco.views;

import com.example.taco.annotations.View;
import com.example.taco.views.components.Layout;
import com.example.taco.views.models.DesignPageViewModel;

import static j2html.TagCreator.*;

@View
public class DesignPageView implements GenericView<DesignPageViewModel> {
    @Override
    public String render(DesignPageViewModel model) {
        return document(
                html(
                        Layout.head(model),
                        body(
                                Layout.header(),

                                Layout.footer(),

                                script().withSrc("/vendor/jquery/jquery.min.js"),
                                script().withSrc("/vendor/bootstrap/js/bootstrap.bundle.min.js")
                        )
                )
        );
    }
}
