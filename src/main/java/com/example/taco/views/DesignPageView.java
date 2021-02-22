package com.example.taco.views;

import com.example.taco.Ingredient;
import com.example.taco.annotations.View;
import com.example.taco.views.components.Layout;
import com.example.taco.views.interfaces.GenericView;
import com.example.taco.views.models.DesignPageViewModel;
import org.springframework.http.HttpMethod;

import static j2html.TagCreator.*;

@View
public class DesignPageView implements GenericView<DesignPageViewModel> {
    private final Layout layout;

    public DesignPageView(Layout layout) {
        this.layout = layout;
    }

    @Override
    public String render(DesignPageViewModel model) {
        return layout.simple(model,
                form().withMethod(HttpMethod.POST.name().toLowerCase()).with(
                        div().withClass("grid").with(
                                div().withId("wraps").withClass("ingredient-group").with(
                                        h3("Designate your wrap:"),
                                        each(model.filterByType(Ingredient.Type.WRAP), ingredient -> div(
                                                label(
                                                        input()
                                                                .withName("ingredients")
                                                                .withType("checkbox")
                                                                .withValue(ingredient.getId()),
                                                        text(ingredient.getName())
                                                )
                                        ))
                                ),
                                div().withId("proteins").withClass("ingredient-group").with(
                                        h3("Pick your protein:"),
                                        each(model.filterByType(Ingredient.Type.PROTEIN), ingredient -> div(
                                                label(
                                                        input()
                                                                .withName("ingredients")
                                                                .withType("checkbox")
                                                                .withValue(ingredient.getId()),
                                                        text(ingredient.getName())
                                                )
                                        ))
                                )
                        )
                )
        );
    }
}
