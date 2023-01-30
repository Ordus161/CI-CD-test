package org.example.springMvcApp.controllers;

import UsersFactory.UsersFactory;
import org.example.springMvcApp.dao.UserDAO;
import org.example.springMvcApp.models.Admin;
import org.example.springMvcApp.models.Moderator;
import org.example.springMvcApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static org.example.springMvcApp.models.UserType.ADMIN;
import static org.example.springMvcApp.models.UserType.MODERATOR;


@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserDAO userDAO;

    @Autowired
    public UsersController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("users", userDAO.index());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable ("id") int id,Model model){
        model.addAttribute("user", userDAO.show(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
       userDAO.save(user);
        return "redirect:/users";
    }

    @GetMapping("/admin")
    public String newAdminUser(Model model) {
        try {
            model.addAttribute("user", UsersFactory.createUser(ADMIN));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "users/new_admin";
    }

    @RequestMapping("/admin")
    @PostMapping()
    public String createAdmin(@ModelAttribute("user")Admin admin) {
        userDAO.save(admin);
        return "redirect:/users";
    }

    @GetMapping("/moderator")
    public String newModeratorUser(Model model) {
        try {
            model.addAttribute("user", UsersFactory.createUser(MODERATOR));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "users/new_moderator";
    }

    @RequestMapping("/moderator")
    @PostMapping()
    public String createModerator(@ModelAttribute("user") Moderator moderator) {
        userDAO.save(moderator);
        return "redirect:/users";
    }
}
