package com.example.taco.views.models.interfaces.basket;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasketItem {
    private String sku;
    private String name;
    private Long quantity;
    private Long total;
}
