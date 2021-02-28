package com.example.taco.controllers;

import com.example.taco.constants.URL;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class BasketController {
    @PostMapping(URL.BASKET)
    public String addTacoToTheBasket(String sku, @CookieValue(value = "basket", defaultValue = "") String basket, HttpServletResponse response) {
        basket = StringUtils.hasLength(basket) ? basket + "|" + sku : sku;
        response.addCookie(new Cookie("basket", basket));
        return "redirect:/";
    }
}