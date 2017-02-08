package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by vanessamnoble on 2/7/17.
 */
@Controller

public class PersonalInfoController {
    @GetMapping("/Resume")
    public String resume(){
       return "PersonalPage";
    }

    @GetMapping("/Portfolio")
    public String portfolio(){
        return "Portfolio";
    }
}
