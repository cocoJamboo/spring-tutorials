/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.sample;

/**
 *
 * @author instruktor
 */
public interface NewsletterService {
    
    void send(String subject, String content);
    
}
