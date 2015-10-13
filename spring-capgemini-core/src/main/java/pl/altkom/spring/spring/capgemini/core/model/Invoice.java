/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.spring.capgemini.core.model;

import java.util.Date;


/**
 *
 * @author kursant1
 */
public class Invoice {
    
    private Date dueDate;
    private Date creationDate;
    private IvoiceTotals invoiceTotals;
    private Order order;
    private Long id;

}
