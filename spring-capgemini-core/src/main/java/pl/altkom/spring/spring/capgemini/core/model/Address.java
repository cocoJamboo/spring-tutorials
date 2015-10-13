/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.spring.capgemini.core.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author kursant5
 */
@Embeddable
public class Address implements Serializable{
    
    private String receiverName;
    private String street;
    private String houseNo;
    private String appartementNo;
    private String zipCode;
    private String city;

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getAppartementNo() {
        return appartementNo;
    }

    public void setAppartementNo(String appartementNo) {
        this.appartementNo = appartementNo;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
}
