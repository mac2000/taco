package com.example.taco.converters;

import com.example.taco.constants.Sku;
import org.springframework.core.convert.converter.Converter;

public class SkuConverter implements Converter<String, Sku> {
    @Override
    public Sku convert(String source) {
        return Sku.valueOf(source.toUpperCase());
    }
}
