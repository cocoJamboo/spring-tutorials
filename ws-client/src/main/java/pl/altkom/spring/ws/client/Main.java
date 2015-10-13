/*
 * Copyright 2014-11-20 the original author or authors.
 */

package pl.altkom.spring.ws.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import pl.altkom.spring.capgemini.web.ws.HelloServiceImplService;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class Main {
    
    public static void main(String[] args) throws MalformedURLException {
        
        WSAuthenticator auth = new WSAuthenticator();
        auth.setUsername("user");
        auth.setPassword("user");
        
        auth.init();
        
        QName qName = new QName("http://ws.web.capgemini.spring.altkom.pl/", 
                "HelloServiceImplService");
        
        HelloServiceImplService srv = new HelloServiceImplService(
                new URL("http://10.12.11.60:8084/spring-capgemini-web/services/HelloWorld")
                , qName); 
        
        String res = srv.getHelloServiceImplPort().sayHallo("Alicja");
        
        System.out.println(res);
        
    }
    
}
