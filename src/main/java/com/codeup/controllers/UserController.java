package com.codeup.controllers;

/**
 * Created by vanessamnoble on 2/15/17.
 */

import com.codeup.models.User;
import com.codeup.repositories.Roles;

import com.codeup.repositories.RolesRepository;
import com.codeup.repositories.UsersRepository;
import com.codeup.services.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController{

    @Autowired
    UsersRepository service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRoles userRoles;


    @Autowired
    RolesRepository roles;

    @Autowired
    UserSvc userSvc;

    @PostMapping("users/create")
    public String saveUser(@Valid User user, Errors validation, Model m){

        if (validation.hasErrors()) {
            m.addAttribute("errors", validation);
            m.addAttribute("user", user);
            return "users/create";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //user.setRole(roles.findByRole("ROLE_USER"));

        User newUser =userSvc.save(user);
        ur.setRole("ROLE_USER");
        ur.setUserId(newUser.getId());
        userRoles.save(ur);

        service.save(user);
        m.addAttribute("user", user);
        return "redirect:/login";
    }

    @GetMapping("users/{id}")
    public String showUser(@PathVariable Long id, Model m){
        User user = service.findById(id);
        m.addAttribute("user", user);
        m.addAttribute("showEditControls", userSvc.isLoggedIn() && user.getUsername() == userSvc.loggedInUser().getUsername());
        return "users/show";
    }

}













}

