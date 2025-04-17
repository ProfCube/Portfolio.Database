package com.example.Neko;

import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {
    @GetMapping("/")
    public String index() {
        return "Greetings from Neko!";
    }


    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name)  {
        return String.format("Hello %s!", name);
    }


}
