# Taco Live Project

Trying to implement live project in TDD manner

[![video](https://img.youtube.com/vi/zLB0UnW3688/0.jpg)](https://www.youtube.com/watch?v=zLB0UnW3688)

# Setting Up the Environment and Bootstrapping the Project

Few minor differences here:

- Added `Spring Boot DevTools`, `Lombok`, `Spring Configuration Processor`
- Going to use [j2html](https://j2html.com/) as rendering engine - hopefully will achieve strongly typed views 💪

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