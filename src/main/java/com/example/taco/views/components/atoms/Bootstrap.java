package com.example.taco.views.components.atoms;

import j2html.tags.ContainerTag;
import j2html.tags.DomContent;

import static j2html.TagCreator.div;

public class Bootstrap {
    public static ContainerTag row(ContainerTag... containerTag) {
        return div().withClass("row").with(containerTag);
    }

    public static ContainerTag row(DomContent domContent) {
        return div().withClass("row").with(domContent);
    }

    public static ContainerTag container(ContainerTag... containerTag) {
        return div().withClass("container").with(containerTag);
    }
}
