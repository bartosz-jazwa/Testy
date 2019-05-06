package com.jazwa.testy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/prywatna")
    String priv(){
        return "private";
    }

    @GetMapping("/sciezka")
    String sciezka(){
        return "private";
    }
}
