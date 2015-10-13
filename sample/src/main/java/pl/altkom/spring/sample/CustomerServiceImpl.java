/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author instruktor
 */
@Component
public class CustomerServiceImpl implements CustomerService {

    @Resource(name = "customerList")
    private List<String> cust;
    
    @Override
    public List<String> newsletterRecipients() {
        return cust;
    }

    public List getCust() {
        return cust;
    }

    public void setCust(List<String> cust) {
        this.cust = cust;
    }
    
}
