package org.example.sprinandspringboot.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloControllerUnitTest {
    @Test
    public void testHelloController() {
        HelloController controller = new HelloController();
        Model model=new BindingAwareModelMap();
        assertEquals("Hello World",controller.sayHello("Fiurar",model));
        assertEquals("Fiurar",model.getAttribute("user"));

        //sau poti face asa
        //ca sa controlezi ambele si una si alta si chiar daca una o sa cada oricum o sa se ruleze ambele

        assertAll(
                ()-> assertEquals("Hello World",controller.sayHello("Fiurar",model)),
                ()->   assertEquals("Fiurar",model.getAttribute("user"))
        );
    }
}
