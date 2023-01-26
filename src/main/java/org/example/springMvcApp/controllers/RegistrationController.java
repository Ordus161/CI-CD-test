package org.example.springMvcApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @GetMapping("/user")
    public String registerNewUser(@RequestParam (value = "name", required = true) String name,
                                  @RequestParam (value = "password", required = true) String password, Model model) {

        model.addAttribute("name", name);
        model.addAttribute("password", password);


        return "registration/new_user";
    }
}
