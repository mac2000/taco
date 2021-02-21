package com.example.taco.views;

import com.example.taco.annotations.View;
import com.example.taco.views.components.Layout;
import com.example.taco.views.interfaces.GenericView;
import com.example.taco.views.models.DesignPageViewModel;

import static j2html.TagCreator.h1;

@View
public class DesignPageView implements GenericView<DesignPageViewModel> {
    private final Layout layout;

    public DesignPageView(Layout layout) {
        this.layout = layout;
    }

    @Override
    public String render(DesignPageViewModel model) {
        return layout.simple(model, h1("DESIGN"));
    }
}
