/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.capgemini.web.controller;

import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.altkom.spring.capgemini.web.model.Customer;

/**
 *
 * @author instruktor
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    private Logger logger = Logger.getLogger(getClass());
    
    @RequestMapping("/add")
    public String addCustomer(Model model) {
        
        Customer customer = new Customer();
        
        model.addAttribute("customer", customer);
        
        return "customer/edit-customer";
    }
    
    @RequestMapping(value = "/save",  method = RequestMethod.POST)
    public String saveCustomer(@Valid Customer customer, BindingResult result) {
        
        logger.debug(customer);
        
        if(result.hasErrors()) {
            logger.warn("błąd walidacji");
            return "customer/edit-customer";
        }
        
        return "redirect:/home";
    }
    
}
