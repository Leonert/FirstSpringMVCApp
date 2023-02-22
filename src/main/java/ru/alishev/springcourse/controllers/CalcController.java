package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {
    @GetMapping("/calc")
    public String calc(@RequestParam("x") int x, @RequestParam("y") int y, @RequestParam("o") char o, Model model) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        int result = 0;
        char choice;
        switch (o) {
            case 'm': result = x*y;
            choice = '*';
            break;
            case 'a': result = x+y;
                choice = '+';
            break;
            case 's': result = x-y;
                choice = '-';
                break;
            case 'd': result = x/y;
                choice = '/';
                break;
            default:
                result = 9999;
                choice = '0';
        }
        model.addAttribute("choice", choice);
        model.addAttribute("result", result);
        return "calc/calc";
    }
}
