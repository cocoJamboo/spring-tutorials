/*
 * Copyright 2014-11-20 the original author or authors.
 */
package pl.altkom.spring.capgemini.web.ws;

import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import pl.altkom.spring.spring.capgemini.core.model.Order;
import pl.altkom.spring.spring.capgemini.core.service.OrderService;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@WebService(endpointInterface = "pl.altkom.spring.capgemini.web.ws.HelloService")
public class HelloServiceImpl implements HelloService {

    @Autowired
    private OrderService orderService;
    
    @Override
    public String sayHallo(String name) {
        return "hallo " + name;
    }
    
    @Override
    public Order loadOrder(long id) {
        return orderService.loadOrder(id);
    }

}
