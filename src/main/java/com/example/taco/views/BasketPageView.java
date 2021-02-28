package com.example.taco.views;

import com.example.taco.annotations.View;
import com.example.taco.constants.URL;
import com.example.taco.views.components.Layout;
import com.example.taco.views.interfaces.GenericView;
import com.example.taco.views.models.BasketPageViewModel;

import static j2html.TagCreator.*;

@View
public class BasketPageView implements GenericView<BasketPageViewModel> {
    private final Layout layout;

    public BasketPageView(Layout layout) {
        this.layout = layout;
    }

    @Override
    public String render(BasketPageViewModel model) {
        return layout.simple(model,
                iffElse(model.getNumberOfBasketItems() == 0,
                        h1("Nothing here").withClass("text-center mt-5 mb-5"),
                        div(
                                h1("Your basket"),
                                table(
                                        thead(
                                                tr(
                                                        th("Title"),
                                                        th("Qty"),
                                                        th("Total"),
                                                        th()
                                                )
                                        ),
                                        tbody(
                                                each(model.getBasketItems(), item -> tr(
                                                        td(item.getName()),
                                                        td(item.getQuantity().toString()),
                                                        td(item.getTotal().toString()),
                                                        td(
                                                                form().withMethod("post").withAction(URL.BASKET_DELETE).with(
                                                                        input().withType("hidden").withName("sku").withValue(item.getSku()),
                                                                        button("Remove").withClass("btn btn-danger")
                                                                )
                                                        )
                                                ).withId(item.getSku()))
                                        )

                                ).withClass("table table-striped")
                        )
                )
        );
    }
}
