/*
 * Copyright 2014-11-20 the original author or authors.
 */

package pl.altkom.spring.capgemini.web;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class TestRM {
    
    @Test
    public void t() {
        
        MockHttpServletRequest request = new MockHttpServletRequest("POST", "/spring-capgemini-web/services/");
        
        RegexRequestMatcher unprotectedMatcher = new RegexRequestMatcher("/services", null);
        
        System.out.println(unprotectedMatcher.matches(request));
        
    }
    
}
