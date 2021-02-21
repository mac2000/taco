package com.example.taco.controllers;

import com.example.taco.constants.Url;
import com.example.taco.views.DesignPageView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DesignController {
    private final DesignPageView view;

    public DesignController(DesignPageView view) {
        this.view = view;
    }

    @GetMapping(Url.DESIGN)
    @ResponseBody
    public String getDesignPage() {
        return view.render();
    }
}
