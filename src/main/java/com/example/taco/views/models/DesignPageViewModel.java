package com.example.taco.views.models;

import com.example.taco.annotations.ViewModel;
import com.example.taco.views.models.interfaces.WithHeadTitle;

@ViewModel
public class DesignPageViewModel implements WithHeadTitle {
    @Override
    public String getHeadTitle() {
        return "Design - Taco Factory";
    }
}
