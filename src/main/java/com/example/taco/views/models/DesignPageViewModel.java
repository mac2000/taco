package com.example.taco.views.models;

import com.example.taco.Ingredient;
import com.example.taco.annotations.ViewModel;
import com.example.taco.constants.URL;
import com.example.taco.views.models.interfaces.LayoutData;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@ViewModel
@Data
public class DesignPageViewModel implements LayoutData {
    private List<Ingredient> ingredients;

    private int numberOfBasketItems;

    @Override
    public String getHeadTitle() {
        return "Design - Taco Factory";
    }

    @Override
    public String getCurrentUrl() {
        return URL.DESIGN;
    }

    public List<Ingredient> filterByType(Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
