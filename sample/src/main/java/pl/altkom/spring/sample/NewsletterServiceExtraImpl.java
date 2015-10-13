/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author instruktor
 */
@Component
public class NewsletterServiceExtraImpl implements NewsletterService{

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    @Qualifier("smtpServiceExtraImpl")
    private SmtpService smtpService;
    
    @Override
    public void send(String subject, String content) {
        
        System.out.println("inna implementacja");
        
        for(String address : customerService.newsletterRecipients()) {
            smtpService.sendMail(address, content, subject);
        }
        
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setSmtpService(SmtpService smtpService) {
        this.smtpService = smtpService;
    }
    
}
