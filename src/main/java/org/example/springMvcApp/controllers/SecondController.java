package org.example.springMvcApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/second")
public class SecondController {

    @GetMapping("/exit")
    public String exit(){
        return "second/exit";
    }
}
