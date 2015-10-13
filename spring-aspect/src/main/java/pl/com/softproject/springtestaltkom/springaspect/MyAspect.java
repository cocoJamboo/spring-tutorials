/*
 * Copyright 2012-09-12 the original author or authors.
 */
package pl.com.softproject.springtestaltkom.springaspect;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class MyAspect {
    
    public void interceptBefore(JoinPoint joinPoint) {
        System.out.println("!!!!! " + joinPoint.getSignature());
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        
        
        
    }
    
}
