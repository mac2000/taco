package com.example.taco.controllers;

import com.example.taco.Taco;
import com.example.taco.constants.Sku;
import com.example.taco.constants.URL;
import com.example.taco.services.TacoService;
import com.example.taco.views.BasketPageView;
import com.example.taco.views.models.BasketPageViewModel;
import com.example.taco.views.models.interfaces.basket.BasketItem;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class BasketController {
    private final BasketPageViewModel model;
    private final BasketPageView view;
    private final TacoService tacoService;

    public BasketController(BasketPageViewModel model, BasketPageView view, TacoService tacoService) {
        this.model = model;
        this.view = view;
        this.tacoService = tacoService;
    }

    @PostMapping(URL.BASKET)
    public String addTacoToTheBasket(Sku sku, @CookieValue(value = "basket", defaultValue = "") String basket, HttpServletResponse response) {
        String id = sku.toString().toLowerCase();
        basket = StringUtils.hasLength(basket) ? basket + "|" + id : id;
        response.addCookie(cookie(basket));
        return "redirect:/";
    }

    @GetMapping(URL.BASKET)
    @ResponseBody
    public String getBasket(@CookieValue(value = "basket", defaultValue = "") String basket) {
        if (StringUtils.hasLength(basket)) {
            Map<String, Long> counted = Arrays.stream(basket.split("\\|")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            Map<String, Taco> tacos = tacoService.findAllById(counted.keySet()).stream().collect(Collectors.toMap(Taco::getSku, taco -> taco));
            List<BasketItem> basketItems = counted.keySet().stream().map(sku -> BasketItem.builder().sku(sku).name(tacos.get(sku).getName()).quantity(counted.get(sku)).total(counted.get(sku) * tacos.get(sku).getPrice()).build()).collect(Collectors.toList());
            model.setBasketItems(basketItems);
        } else {
            model.setBasketItems(new ArrayList<>());
        }

        model.setNumberOfBasketItems(StringUtils.hasLength(basket) ? basket.split("\\|").length : 0);

        return view.render(model);
    }

    @PostMapping(URL.BASKET_DELETE)
    public String deleteItemFromBasket(String sku, @CookieValue(value = "basket", defaultValue = "") String basket, HttpServletResponse response) {
        basket = basket.replaceFirst("\\|?" + sku, "").replaceAll("(^\\||\\|$)", "");
        response.addCookie(cookie(basket));
        return "redirect:" + URL.BASKET;
    }

    private Cookie cookie(String basket) {
        Cookie cookie = new Cookie("basket", basket);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        return cookie;
    }
}
