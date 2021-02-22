package com.example.taco.controllers;

import com.example.taco.constants.URL;
import com.example.taco.services.interfaces.TacoServiceInterface;
import com.example.taco.views.HomePageView;
import com.example.taco.views.models.HomePageViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    private final HomePageView view;
    private final HomePageViewModel model;
    private final TacoServiceInterface tacoService;

    public HomeController(HomePageView view, HomePageViewModel model, TacoServiceInterface tacoService) {
        this.view = view;
        this.model = model;
        this.tacoService = tacoService;
    }

    @GetMapping(URL.HOME)
    @ResponseBody
    public String getHomePage() {
        model.setTacos(tacoService.findAll());
        return view.render(model);
    }
}
