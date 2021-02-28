package com.example.taco.views.models;

import com.example.taco.annotations.ViewModel;
import com.example.taco.constants.URL;
import com.example.taco.views.models.interfaces.LayoutData;
import com.example.taco.views.models.interfaces.basket.BasketItem;
import com.example.taco.views.models.interfaces.basket.WithBasketItems;
import lombok.Data;

import java.util.List;

@ViewModel
@Data
public class BasketPageViewModel implements LayoutData, WithBasketItems {
    private int numberOfBasketItems;
    private List<BasketItem> basketItems;

    @Override
    public String getHeadTitle() {
        return "Basket - Taco Factory";
    }

    @Override
    public String getCurrentUrl() {
        return URL.BASKET;
    }
}
