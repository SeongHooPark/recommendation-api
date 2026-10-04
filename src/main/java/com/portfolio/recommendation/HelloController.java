package com.portfolio.recommendation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {

    @GetMapping("/hello-json")
    public Greeting helloJson(@RequestParam String name) {
        return new Greeting(name, "안녕, 첫 서버야");
    }
}
