package com.example.taco.views.models;

import com.example.taco.annotations.ViewModel;
import com.example.taco.constants.URL;
import com.example.taco.views.models.interfaces.LayoutData;

@ViewModel
public class HomePageViewModel implements LayoutData {
    @Override
    public String getHeadTitle() {
        return "Home - Taco Factory";
    }

    @Override
    public String getCurrentUrl() {
        return URL.HOME;
    }
}
