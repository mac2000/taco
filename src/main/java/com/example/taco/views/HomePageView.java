package com.example.taco.views;

import com.example.taco.Taco;
import com.example.taco.annotations.View;
import com.example.taco.constants.URL;
import com.example.taco.views.components.Carousel;
import com.example.taco.views.components.Layout;
import com.example.taco.views.interfaces.GenericView;
import com.example.taco.views.models.HomePageViewModel;
import j2html.tags.ContainerTag;

import java.util.List;

import static com.example.taco.views.components.atoms.Bootstrap.row;
import static j2html.TagCreator.*;

@View
public class HomePageView implements GenericView<HomePageViewModel> {
    private final Layout layout;
    private final Carousel carousel;

    public HomePageView(Layout layout, Carousel carousel) {
        this.layout = layout;
        this.carousel = carousel;
    }

    @Override
    public String render(HomePageViewModel model) {
        return layout.leftSidebar(model,
                div(
                        h1("Taco Factory").withClass("my-4"),
                        div().withClass("list-group").with(
                                listGroupItem("Category 1"),
                                listGroupItem("Category 2"),
                                listGroupItem("Category 3")
                        )
                ),
                div(
                        carousel.carousel(),
                        productList(model.getTacos())
                ));
    }

    private ContainerTag listGroupItem(String title) {
        return a(title).withClass("list-group-item").withHref("#");
    }

    private ContainerTag productList(List<Taco> tacos) {
        return row(each(tacos, this::productItem));
    }

    private ContainerTag productItem(Taco taco) {
        return div().withClass("col-lg-4 col-md-6 mb-4").with(
                div().withClass("card h-100").with(
                        a().withHref("#").with(
                                img().withClass("card-img-top").withAlt("").withSrc("http://placehold.it/700x400")
                        ),
                        div().withClass("card-body").with(
                                h4().withClass("card-title").with(
                                        a(taco.getName()).withHref("#")
                                ),
                                h5("£" + (taco.getPrice() / 100)),
                                p("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur!").withClass("card-text")

                        ),
                        div().withClass("card-footer d-flex justify-content-between align-items-center").with(
                                small("⭐ ⭐ ⭐ ⭐ ⭐").withClass("text-muted"),
                                form().withAction(URL.BASKET).withMethod("post").with(
                                        input().withType("hidden").withName("sku").withValue(taco.getSku()),
                                        button("Add").withClass("btn btn-primary").withType("submit")
                                )
                        )
                )
        );
    }
}
