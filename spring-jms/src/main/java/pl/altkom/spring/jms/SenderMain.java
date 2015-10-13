/*
 * Copyright 2014-11-21 the original author or authors.
 */

package pl.altkom.spring.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class SenderMain {
    
    public static void main(String[] args) {
        ApplicationContext ctx = 
                new ClassPathXmlApplicationContext("sender-context.xml");
        
        JmsTemplate jms = ctx.getBean(JmsTemplate.class);
        
        jms.send(new MessageCreator() {

            @Override
            public Message createMessage(Session sn) throws JMSException {
                 TextMessage message = sn.createTextMessage("ala ma kota");
                 
                 return message;
            }
        });
    }
    
}
