package com.example.taco.controllers;

import com.example.taco.constants.Url;
import com.example.taco.views.HomePageView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    private final HomePageView view;

    public HomeController(HomePageView view) {
        this.view = view;
    }

    @GetMapping(Url.HOME)
    @ResponseBody
    public String getHomePage() {
        return view.render();
    }
}
