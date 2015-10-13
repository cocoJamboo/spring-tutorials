/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.sample;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author instruktor
 */
@Component
public class SmtpServiceImpl implements SmtpService {

    @Value("${smtp.server}")
    private String mailServerName;
    @Value("${smtp.user}")
    private String mailUser;
    @Value("${smtp.pass}")
    private String mailPasswd;
    
    @Override
    public void sendMail(String address, String content, String subject) {
        System.out.println("sending: " + address + " " + subject);
    }

    
    public void setMailServerName(String mailServerName) {
        
        System.out.println("seter");
        
        this.mailServerName = mailServerName;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public void setMailPasswd(String mailPasswd) {
        this.mailPasswd = mailPasswd;
    }
    
    @PostConstruct
    private void init2() {
        
        System.out.println("inicajlizuję SMTP Service 22");
        
        System.out.println("mailServerName: " + mailServerName);
        
    }
    
    public void init() {
        
        System.out.println("inicajlizuję SMTP Service");
        
        System.out.println("mailServerName: " + mailServerName);
        
    }
    
    @PreDestroy
    public void destroy() {
        System.out.println("sprzątanie");
    }
            
}
