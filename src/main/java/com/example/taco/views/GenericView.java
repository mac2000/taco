package com.example.taco.views;

public interface GenericView<T> {
    String render(T model);
}
