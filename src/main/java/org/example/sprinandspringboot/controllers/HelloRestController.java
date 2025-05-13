package org.example.sprinandspringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @GetMapping("/rest")
    public GreetingsController greetingsController(@RequestParam(defaultValue = "Worlds") String name) {
        return new GreetingsController("Hello " + name);
    }
}

record GreetingsController(String message) {
}
