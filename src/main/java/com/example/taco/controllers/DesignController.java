package com.example.taco.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DesignController {
    @GetMapping("/design")
    public String getDesignPage() {
        return "";
    }
}
