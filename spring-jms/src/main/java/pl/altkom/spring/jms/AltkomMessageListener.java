/*
 * Copyright 2014-11-21 the original author or authors.
 */

package pl.altkom.spring.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Adrian Lapierre <adrian@softproject.com.pl>
 */
public class AltkomMessageListener implements MessageListener  {

    @Override
    public void onMessage(Message msg) {
        
        System.out.println("wiadomosc:");
        
        if(msg instanceof TextMessage) {
            try {
                System.out.println(((TextMessage)msg).getText());
            } catch (JMSException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    
}
