/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom.spring.spring.capgemini.core.dao.springdata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.altkom.spring.spring.capgemini.core.model.Order;
import pl.altkom.spring.spring.capgemini.core.model.OrderItem;
import pl.altkom.spring.spring.capgemini.core.model.Product;
import pl.altkom.spring.spring.capgemini.core.model.User;

/**
 *
 * @author instruktor
 */
@ContextConfiguration("/core-test-context.xml")
@TransactionConfiguration(defaultRollback = false)
public class OrderDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private OrderDAO orderDAO;
    
    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private UserDAO userDAO;
    
    @Test
    public void testCreate() {

        User user = userDAO.findOne(1L);
        
        if(user == null) {
            user = new User();
            user.setLogin("ala");
            user.setPassword("alalalal");
            userDAO.save(user);
        } 
        
        List<OrderItem> items = new ArrayList<>();
        
        OrderItem item = new OrderItem();
        
        Product product;
        
        if(!productDAO.exists(1L)) {
            product = new Product();
            product.setColor("biały");
            product.setCurrency("PLN");
            product.setCost(BigDecimal.valueOf(123.55));
            productDAO.save(product);
        } else {
//            product = new Product();
//            product.setId(1L);
            product = productDAO.findOne(1L);
        }
        
        item.setProduct(product);
        item.setAmount(1);
        item.setDiscount(0);
        items.add(item);
        
        Order order = new Order();
        order.setOrderList(items);
        order.setUser(user);
        
        orderDAO.save(order);
        
    }
    
    @Test
    public void testFindByUserId() {
        
        List<Order> res = orderDAO.findByUserId(1);
        
        System.out.println(res);
        
    }
    
    @Test
    public void testFindByUserIdPagabled() {
        
        Page<Order> res = orderDAO.findPagedable(new PageRequest(0, 10, 
                Sort.Direction.DESC, "id", "orderDate"));
        //Page<Order> res = orderDAO.findAll(new PageRequest(0, 10));
        //System.out.println(res);
        
        System.out.println("page count " + res.getTotalPages());
        
        for(Order order : res) {
            System.out.println(order);
        }
        
    }

}
