/*
 * Copyright 2014-11-21 the original author or authors.
 */

package pl.altkom.spring.spring.jmx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        
        ApplicationContext ctx = 
                new ClassPathXmlApplicationContext("spring-context.xml");
        
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
    }
    
}
