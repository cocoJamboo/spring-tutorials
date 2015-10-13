/*
 * Copyright 2012-09-12 the original author or authors.
 */
package pl.com.softproject.springtestaltkom.springaspect;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class MyInterceptor {
    
    public void intercept(ProceedingJoinPoint proceedingJoinPoint) {
        
        System.out.println("interceptor przed metodą");
        
        Object[] params = {2}; 
        
        try {
            
            if(proceedingJoinPoint.getArgs().length != 0) {
                proceedingJoinPoint.proceed(params);
            } else {
                proceedingJoinPoint.proceed();
            }
        } catch (Throwable ex) {
            Logger.getLogger(MyInterceptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("interceptor po metodzie");
        
    }
    
}
