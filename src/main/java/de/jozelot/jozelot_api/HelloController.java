package de.jozelot.jozelot_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private int clicks = 0;

    @GetMapping("/hello")
    public String hello() {
        String text = "Clicks: " + ++clicks + "; Hello!";
        return text;
    }
}
