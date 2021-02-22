package com.example.taco;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Taco {
    private String id;
    private String name;
    private Integer price;
}
