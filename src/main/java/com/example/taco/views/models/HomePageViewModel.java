package com.example.taco.views.models;

import com.example.taco.Taco;
import com.example.taco.annotations.ViewModel;
import com.example.taco.constants.URL;
import com.example.taco.views.models.interfaces.LayoutData;
import lombok.Data;

import java.util.List;

@ViewModel
@Data
public class HomePageViewModel implements LayoutData {
    private List<Taco> tacos;

    @Override
    public String getHeadTitle() {
        return "Home - Taco Factory";
    }

    @Override
    public String getCurrentUrl() {
        return URL.HOME;
    }
}
