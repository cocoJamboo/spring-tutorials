/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.spring.capgemini.core.model;

import java.util.List;

/**
 *
 * @author kursant3
 */
public class ShoppingCart {
    
    private List<OrderItem> currentItems;

    public List<OrderItem> getCurrentItems() {
        return currentItems;
    }

    public void setCurrentItems(List<OrderItem> currentItems) {
        this.currentItems = currentItems;
    }

}
