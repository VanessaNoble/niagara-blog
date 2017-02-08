package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by vanessamnoble on 2/8/17.
 */
@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String userRoll() {
        return "userRoll";
    }

    @GetMapping("/check-guess/{n}")
    public String checkGuess(@PathVariable int n, Model model) {
        int random = (int) (Math.random() * 6 + 1);

        model.addAttribute("n", n);
        model.addAttribute("random", random);

        return "n";
    }
}

