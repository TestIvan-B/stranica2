package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {
    //display list of persons

    @Autowired
    private PersonService personService;


    @GetMapping("/")
    public String viewHomePage(Model model){
       model.addAttribute("listPersons", personService.getAllPersons());
       return "index";
    }

    @GetMapping("/showNewPersonForm")
    public String showNewPersonForm(Model model){
        Person person= new Person();
        model.addAttribute("person", person);
        return "new_person";
    }

    @PostMapping("/savePerson")
    public String savePerson(@ModelAttribute("person") Person person){
        personService.savePerson(person);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value ="id") long id, Model model){

        Person person= personService.getPersonById(id);
        model.addAttribute("person", person);
        return "update_person";
    }

    @GetMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable (value = "id") long id ){

        this.personService.deletePersonById(id);
        return "redirect:/";
    }
}
