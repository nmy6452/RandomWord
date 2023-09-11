package com.nmy.randomword.Controller.Web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class ViewControlller {
    @GetMapping("/api/hello")
    public String test() {
        return "Hello, world!";
    }
}
