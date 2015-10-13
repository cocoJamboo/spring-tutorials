/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.spring.capgemini.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.altkom.spring.spring.capgemini.core.dao.springdata.OrderDAO;
import pl.altkom.spring.spring.capgemini.core.dao.springdata.OrderItemDAO;
import pl.altkom.spring.spring.capgemini.core.model.Order;

/**
 *
 * @author instruktor
 */
@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private OrderItemDAO orderItemDAO;

    
    @Override
    @Secured("ROLE_ADMIN")
    public Order loadOrder(long id) {
        return orderDAO.findOne(id);
    }
    
    @Transactional
    @Override
    @Secured("ROLE_ADMIN")
    public void createOrder(Order order) {        
        orderDAO.save(order);
    }
    
    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public void setOrderItemDAO(OrderItemDAO orderItemDAO) {
        this.orderItemDAO = orderItemDAO;
    }
    
    
    
}
