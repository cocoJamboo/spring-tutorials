/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.capgemini.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.altkom.spring.spring.capgemini.core.model.Order;
import pl.altkom.spring.spring.capgemini.core.service.OrderService;

/**
 *
 * @author instruktor
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @RequestMapping( value = "/load/{id}", method = RequestMethod.GET)
    public String load(Model model, @PathVariable int id) {
        
        Order order = orderService.loadOrder(id);
        
        model.addAttribute("order", order);
        
        return "order/display";
    }
    
}
