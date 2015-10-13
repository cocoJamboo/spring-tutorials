/*
 * Copyright 2012-09-12 the original author or authors.
 */
package pl.com.softproject.springtestaltkom.springaspect;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class TargetBean implements NewInterface {
    
    @Override
    public void someMethod(int id) {
        System.out.println("w metodzie !!! id = " + id);
    }
    
    @Override
    public void method2() {
        System.out.println("w metodzie drugiej");
    }
    
}
