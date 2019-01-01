/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.entity;

/**
 *
 * @author User
 */
public class OrderPayment {
    private String opId;   
    private String orderId; 
    private String  date;     
    private double advance;  
    private double fullPayment;

    public OrderPayment() {
    }

    public OrderPayment(String opId, String orderId, String date, double advance, double fullPayment) {
        this.opId = opId;
        this.orderId = orderId;
        this.date = date;
        this.advance = advance;
        this.fullPayment = fullPayment;
    }

    /**
     * @return the opId
     */
    public String getOpId() {
        return opId;
    }

    /**
     * @param opId the opId to set
     */
    public void setOpId(String opId) {
        this.opId = opId;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the advance
     */
    public double getAdvance() {
        return advance;
    }

    /**
     * @param advance the advance to set
     */
    public void setAdvance(double advance) {
        this.advance = advance;
    }

    /**
     * @return the fullPayment
     */
    public double getFullPayment() {
        return fullPayment;
    }

    /**
     * @param fullPayment the fullPayment to set
     */
    public void setFullPayment(double fullPayment) {
        this.fullPayment = fullPayment;
    }

}
