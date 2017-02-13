package com.codeup.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import com.codeup.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by vanessamnoble on 2/13/17.
 */
@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/register")
    public String showForm(Model m){
        m.addAttribute("user", new User());
        return"users/create";
    }
}
