package com.example.taco.views.interfaces;

public interface GenericView<T> {
    String render(T model);
}
