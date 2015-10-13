/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.capgemini.jaxb;

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;
import pl.com.softproject.commons.model.invoice.Invoice;

/**
 *
 * @author instruktor
 */
public class InvoiceSerializerTest {
    
   @Test
   public void testParse() {
 
       InvoiceSerializer serializer = new InvoiceSerializer();
       
       Invoice invoice = serializer.fromFile(new File("src/main/resources/FS 1_MAG_05_2012.xml"));
       
       System.out.println(serializer.toString(invoice));
       
   }

    @Test
    public void testCrateXML() {
    
        InvoiceSerializer serializer = new InvoiceSerializer();
        
        Invoice invoice = new Invoice();
        
        invoice.setBuyer("kupujący");
        invoice.setSeller("sprzedawca");
        
        String str = serializer.toString(invoice, false);
    
        System.out.println(str);
        
    }
    
}
