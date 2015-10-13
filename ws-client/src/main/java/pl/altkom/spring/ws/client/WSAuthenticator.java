/*
 * Copyright 2014-11-20 the original author or authors.
 */

package pl.altkom.spring.ws.client;

import com.sun.org.apache.bcel.internal.util.JavaWrapper;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class WSAuthenticator extends Authenticator {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //@PostConstruct
    public void init(){
        Authenticator.setDefault(this);
    }
    
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        
        //"admin", "test.112"
        PasswordAuthentication pass = new PasswordAuthentication(username, password.toCharArray());
        
        return pass;
    }
    
    
}
