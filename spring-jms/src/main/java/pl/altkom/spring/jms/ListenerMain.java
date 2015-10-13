/*
 * Copyright 2014-11-21 the original author or authors.
 */

package pl.altkom.spring.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class ListenerMain {
    
    public static void main(String[] args) {
        
        ApplicationContext ctx = 
                new ClassPathXmlApplicationContext("listener-conext.xml");
        
    }
    
}
