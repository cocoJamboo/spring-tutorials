/*
 * Copyright 2012-09-12 the original author or authors.
 */
package pl.com.softproject.springtestaltkom.springaspect;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
@ContextConfiguration("/spring-context.xml")
public class TestAspect extends AbstractJUnit4SpringContextTests {
    
    @Autowired
    NewInterface bean;
    
    @Test
    public void test() {
        bean.someMethod(1);
        bean.method2();
    }
}
