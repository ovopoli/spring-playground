package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagesController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/math/pi")
    public String pi() {
        return "3.141592653589793";
    }
    @GetMapping("/math/calculate")
    public String calculate(@RequestParam Integer x, @RequestParam Integer y, @RequestParam(defaultValue = "add") String operation) {
        return MathService.calculate(operation, x, y).toString();
    }
    @PostMapping("/math/sum")
    public String sum(@RequestParam Integer [] n) {
        return MathService.sum(n).toString();
    }
}
