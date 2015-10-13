/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.altkom.spring.spring.capgemini.core.model;

import java.util.Date;

/**
 *
 * @author Joanna
 */
public class Shipment {
    private Date readyForShipmentDate;
    private Date shipmentDate;
    private Date deliveryDate;
    private String deliveryMethod;
    private String waybill;
    private String undeliverableReason;

    public Date getReadyForShipmentDate() {
        return readyForShipmentDate;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public String getWaybill() {
        return waybill;
    }

    public String getUndeliverableReason() {
        return undeliverableReason;
    }

    public void setReadyForShipmentDate(Date readyForShipmentDate) {
        this.readyForShipmentDate = readyForShipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public void setWaybill(String waybill) {
        this.waybill = waybill;
    }

    public void setUndeliverableReason(String undeliverableReason) {
        this.undeliverableReason = undeliverableReason;
    }
    
    
}
