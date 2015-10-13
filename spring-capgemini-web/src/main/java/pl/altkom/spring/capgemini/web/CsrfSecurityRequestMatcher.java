/*
 * Copyright 2014-11-20 the original author or authors.
 */

package pl.altkom.spring.capgemini.web;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class CsrfSecurityRequestMatcher implements RequestMatcher{

    private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");
    //private RegexRequestMatcher unprotectedMatcher = new RegexRequestMatcher("/spring-capgemini-web/services/HelloWorld", null);
    
    @Override
    public boolean matches(HttpServletRequest request) {
        
        boolean result = ! request.getRequestURI().matches(".+/services/.+");
        
        if(allowedMethods.matcher(request.getMethod()).matches()){
            return false;
        }
 
        return result;
        
        
    }
    
}
