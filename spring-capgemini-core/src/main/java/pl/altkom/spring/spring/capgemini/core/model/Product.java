/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.spring.capgemini.core.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author kursant6
 */
@Entity
public class Product extends BaseEntiy {
    
    
    private String name;
    private String color;
    private String substance;
    @Column(precision=8, scale=2)
    private BigDecimal weightKg;
    @Column(precision=8, scale=2)
    private BigDecimal widthCm;
    @Column(precision=8, scale=2)
    private BigDecimal heightCm;
    @Column(precision=8, scale=2)
    private BigDecimal lengthCm;
    @Column(precision=8, scale=2)
    private BigDecimal cost;
    @Column(precision=8, scale=2)
    private BigDecimal tax;
    private String currency;
    //private Supplier supplier;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSubstance() {
        return substance;
    }

    public void setSubstance(String substance) {
        this.substance = substance;
    }

    public BigDecimal getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(BigDecimal weightKg) {
        this.weightKg = weightKg;
    }

    public BigDecimal getWidthCm() {
        return widthCm;
    }

    public void setWidthCm(BigDecimal widthCm) {
        this.widthCm = widthCm;
    }

    public BigDecimal getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(BigDecimal heightCm) {
        this.heightCm = heightCm;
    }

    public BigDecimal getLengthCm() {
        return lengthCm;
    }

    public void setLengthCm(BigDecimal lengthCm) {
        this.lengthCm = lengthCm;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

//    public Supplier getSupplier() {
//        return supplier;
//    }
//
//    public void setSupplier(Supplier supplier) {
//        this.supplier = supplier;
//    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", color=" + color + ", substance=" + substance + ", weightKg=" + weightKg + ", widthCm=" + widthCm + ", heightCm=" + heightCm + ", lengthCm=" + lengthCm + ", cost=" + cost + ", tax=" + tax + ", currency=" + currency + '}';
    }
    
}
