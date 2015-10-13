/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.spring.capgemini.core.service;

import org.springframework.transaction.annotation.Transactional;
import pl.altkom.spring.spring.capgemini.core.model.Order;

/**
 *
 * @author instruktor
 */
public interface OrderService {

    
    void createOrder(Order order);

    Order loadOrder(long id);
    
}
