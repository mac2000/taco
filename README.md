# Taco Live Project

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=mac2000_taco&metric=alert_status)](https://sonarcloud.io/dashboard?id=mac2000_taco)

Trying to implement live project in TDD manner

[![video](https://img.youtube.com/vi/zLB0UnW3688/0.jpg)](https://www.youtube.com/watch?v=zLB0UnW3688)

# Setting Up the Environment and Bootstrapping the Project

Few minor differences here:

- Added `Spring Boot DevTools`, `Lombok`, `Spring Configuration Processor`
- Going to use [j2html](https://j2html.com/) as rendering engine - hopefully will achieve strongly typed views 💪

# Building the Catalog

Instead of htmlunit going to use selenide which gives way better experience.

Instead of flyway going to use liquibase because of its database agnostic migrations.

# Adding a Basket Feature

Instead of dealing with basket storage going to use cookies as transport

# TODO

## Rendering ContainerTag

Wondering if it is possible instead of

```java

@Controller
public class MyAwesomeController {
    @GetMapping("/")
    @ResponseBody
    public String get() {
        return document(
            html(
                body(
                    h1("Hello World")
                )
            )
        )
    }
}
```

Have something like:

```java
@RestController
public class MyAwesomeController {
    @GetMapping("/")
    public ContainerTag get() {
        return html(
            body(
                h1("Hello World")
            )
        )
    }
}
```

Need a way to tell spring what should be done in such case.