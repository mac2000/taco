package com.example.taco.views.models;

import com.example.taco.annotations.ViewModel;
import com.example.taco.constants.URL;
import com.example.taco.views.models.interfaces.WithCurrentUrl;
import com.example.taco.views.models.interfaces.WithHeadTitle;

@ViewModel
public class HomePageViewModel implements WithHeadTitle, WithCurrentUrl {
    @Override
    public String getHeadTitle() {
        return "Home - Taco Factory";
    }

    @Override
    public String getCurrentUrl() {
        return URL.HOME;
    }
}
