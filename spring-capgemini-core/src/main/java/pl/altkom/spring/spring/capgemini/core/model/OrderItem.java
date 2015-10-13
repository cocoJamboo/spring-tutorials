/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.spring.capgemini.core.model;
        
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Reprezentacja pojedynczego elementu zamówenia.
 * 
 * @author kursant4
 */
@Entity
public class OrderItem extends BaseEntiy {
    
    // ilosc zamowionych produktow
    int amount;
    
    // rabat w procentach
    int discount;
    
    // zamowiony produkt
    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
}