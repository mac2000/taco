package com.example.taco.views;

import com.example.taco.Ingredient;
import com.example.taco.annotations.View;
import com.example.taco.views.components.Layout;
import com.example.taco.views.interfaces.GenericView;
import com.example.taco.views.models.DesignPageViewModel;
import j2html.tags.ContainerTag;
import org.springframework.http.HttpMethod;

import java.util.List;

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
                                renderCheckboxesBlock("wraps", "Designate your wrap:", model.filterByType(Ingredient.Type.WRAP)),
                                renderCheckboxesBlock("proteins", "Pick your protein:", model.filterByType(Ingredient.Type.PROTEIN)),
                                renderCheckboxesBlock("cheeses", "Choose your cheese:", model.filterByType(Ingredient.Type.CHEESE)),
                                renderCheckboxesBlock("veggies", "Determine your veggies:", model.filterByType(Ingredient.Type.VEGGIES)),
                                renderCheckboxesBlock("sauces", "Select your sauce:", model.filterByType(Ingredient.Type.SAUCE)),
                                div(
                                        h3("Name your taco creation:"),
                                        input()
                                                .withName("name")
                                                .withType("text")
                                ),
                                div(
                                        button("Submit your taco")
                                )
                        )
                )
        );
    }

    private ContainerTag renderCheckboxesBlock(String id, String title, List<Ingredient> ingredients) {
        return div().withId(id).withClass("ingredient-group").with(
                h3(title),
                each(ingredients, ingredient -> div(
                        label(
                                input()
                                        .withName("ingredients")
                                        .withType("checkbox")
                                        .withValue(ingredient.getId()),
                                text(ingredient.getName())
                        )
                ))
        );
    }
}
