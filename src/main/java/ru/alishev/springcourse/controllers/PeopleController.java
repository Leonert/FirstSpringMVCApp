package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alishev.springcourse.DAO.PeopleDAO;
import ru.alishev.springcourse.models.Person;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PeopleDAO peopleDAO;

    public PeopleController(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("people", peopleDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", peopleDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String getPersonAddingForm(@ModelAttribute("person") Person person, Model model) {
        return "people/new";
    }

    @PostMapping()
    public String addPerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "people/new";
        peopleDAO.add(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", peopleDAO.show(id));
        return "people/edit";
    }

    @PostMapping("/{id}")
    public String editName(@ModelAttribute("person") Person person, @PathVariable ("id") int id) {
        peopleDAO.edit(id, person);
        return "redirect:/people";
    }
}
