package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.tags.Param;
import ru.alishev.springcourse.models.TestPerson;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("text", "Hello world");
        model.addAttribute("person", new TestPerson("Tom", 12));
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "qqq");
        model.addAttribute("map", map);
        return "test";
    }
}
