/*
 * Copyright 2011-08-31 the original author or authors.
 */
package pl.altkom.spring.capgemini.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pl.altkom.spring.capgemini.web.model.Person;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@Controller
public class MyController {
    
    protected Logger logger = Logger.getLogger(getClass());
    
    @RequestMapping("/home")
    public ModelAndView home() {
        
        logger.debug("MyController.home()");
        
        ModelAndView model = new ModelAndView("home");
        
        return model;
    }
    
    @RequestMapping("/person/show/{id}")
    public String personShow(Model model, @PathVariable int id) {
        
        logger.debug("MyController.personShow()");
        
        model.addAttribute("id", -1234);
        
        return "person";
    }
    
    @RequestMapping(value = "/person/{id}")
    public @ResponseBody Person person(Model model, @PathVariable int id) {
        
        logger.debug("MyController.person()");
        
        Person person = new Person("Jan", "Kowąlski");
        
        return person;
    }
    
}
