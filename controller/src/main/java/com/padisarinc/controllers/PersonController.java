package com.padisarinc.controllers;

import com.padisarinc.entities.Person;
import com.padisarinc.servicecontract.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;

@Controller
@RequestMapping(value = "/")
public class PersonController {
    @Autowired
    private PersonService personService;

    /**
     * You can write this method instead of below method
     *     @RequestMapping(method = RequestMethod.GET)
     *     public String goHome(@ModelAttribute Person person) {
     *         return "index";
     *     }
     */
    @RequestMapping(method = RequestMethod.GET)
    public String goHome(Model model) {
        Person p = new Person();
        model.addAttribute("person", p);
        return "index";
    }

    //@PostMapping(value = "/save")//@RequestMapping(value = "/save", method = RequestMethod.POST)//equals @PostMapping("/save")
    @RequestMapping(value = "/save", method = RequestMethod.POST)//equals @PostMapping("/save")
    public String save(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {

        if(bindingResult != null) {
            return "index";
        }

        System.out.println(person);
        personService.save(person);
        return "done";
    }
}