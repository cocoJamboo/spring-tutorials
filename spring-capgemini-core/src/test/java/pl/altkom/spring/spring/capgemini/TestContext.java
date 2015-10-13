/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.spring.capgemini;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.altkom.spring.spring.capgemini.core.dao.springdata.UserDAO;
import pl.altkom.spring.spring.capgemini.core.model.User;

/**
 *
 * @author instruktor
 */
@ContextConfiguration("/core-test-context.xml")
@TransactionConfiguration(defaultRollback = false)
public class TestContext extends AbstractTransactionalJUnit4SpringContextTests{
    
    @Autowired
    private UserDAO userDAO;
    
    @Test
    public void test() {
        System.out.println("OK");
        
        //User res = userDAO.findOne(5L);
        
        //System.out.println(res);
        
    }
    
    @Test
    public void saveUserTest() {
        
        User u = new User();
        u.setLogin("ala");
        u.setPassword("alamakota");
        
        userDAO.save(u);
        
        
        System.out.println(u.getId());
    }
    
    @Test
    public void testFind() {
        List<User> users = userDAO.findByLoginLikeIgnoreCase("ala");
        
        System.out.println(users);
    
    }
    
    @Test
    public void testFindByActiveTrueOrderById() {
        
        System.out.println(userDAO.findByActiveTrue());
        
    }
    
}
