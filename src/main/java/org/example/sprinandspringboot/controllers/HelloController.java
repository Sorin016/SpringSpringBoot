package org.example.sprinandspringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")  //redirect to htt
    public String sayHello(@RequestParam(defaultValue = "world")String name, Model model) {
        model.addAttribute("user", name);
        return "Hello World";
    }
}
