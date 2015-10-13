/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractRefreshableConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author instruktor
 */
public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("!!!!!");
        
         AbstractRefreshableConfigApplicationContext ctx = 
                new ClassPathXmlApplicationContext("spring-context.xml");
        
        ctx.registerShutdownHook();
         
        NewsletterService newsletterService = ctx.getBean("newsletterServiceImpl", 
                NewsletterService.class);
        newsletterService.send("treść", "temat");
        
        //ctx.close();
        
        
        
    }
    
    
}
