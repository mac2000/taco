package com.example.taco.views;

import com.example.taco.annotations.View;
import com.example.taco.views.models.DesignPageViewModel;

import static com.example.taco.views.components.Layout.simple;
import static j2html.TagCreator.h1;

@View
public class DesignPageView implements GenericView<DesignPageViewModel> {
    @Override
    public String render(DesignPageViewModel model) {
        return simple(model, h1("DESIGN"));
    }
}
