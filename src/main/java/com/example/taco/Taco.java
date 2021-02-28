package com.example.taco;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Taco {
    private String sku;
    private String name;
    private int price;
}
