package com.example.taco.controllers;

import com.example.taco.constants.URL;
import com.example.taco.views.DesignPageView;
import com.example.taco.views.models.DesignPageViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DesignController {
    private final DesignPageView view;
    private final DesignPageViewModel model;

    public DesignController(DesignPageView view, DesignPageViewModel model) {
        this.view = view;
        this.model = model;
    }

    @GetMapping(URL.DESIGN)
    @ResponseBody
    public String getDesignPage() {
        return view.render(model);
    }
}
