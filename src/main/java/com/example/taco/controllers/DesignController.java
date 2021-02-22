package com.example.taco.controllers;

import com.example.taco.Ingredient;
import com.example.taco.constants.URL;
import com.example.taco.views.DesignPageView;
import com.example.taco.views.models.DesignPageViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class DesignController {
    private final DesignPageView view;
    private final DesignPageViewModel model;

    public DesignController(DesignPageView view, DesignPageViewModel model) {
        this.view = view;
        this.model = model;
    }

    @GetMapping(URL.DESIGN)
    @ResponseBody
    public String getDesignPage() {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        );

        model.setIngredients(ingredients);

        return view.render(model);
    }
}
