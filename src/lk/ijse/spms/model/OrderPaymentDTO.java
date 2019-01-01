/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.model;

/**
 *
 * @author User
 */
public class OrderPaymentDTO {
    private String opaymentId;   
    private String orderId; 
    private String paymentDate;     
    private double OrderAdvance;  
    private double OrderFullPayment;

    public OrderPaymentDTO() {
    }

    public OrderPaymentDTO(String opaymentId, String orderId, String paymentDate, double OrderAdvance, double OrderFullPayment) {
        this.opaymentId = opaymentId;
        this.orderId = orderId;
        this.paymentDate = paymentDate;
        this.OrderAdvance = OrderAdvance;
        this.OrderFullPayment = OrderFullPayment;
    }

    /**
     * @return the opaymentId
     */
    public String getOpaymentId() {
        return opaymentId;
    }

    /**
     * @param opaymentId the opaymentId to set
     */
    public void setOpaymentId(String opaymentId) {
        this.opaymentId = opaymentId;
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
     * @return the paymentDate
     */
    public String getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param paymentDate the paymentDate to set
     */
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * @return the OrderAdvance
     */
    public double getOrderAdvance() {
        return OrderAdvance;
    }

    /**
     * @param OrderAdvance the OrderAdvance to set
     */
    public void setOrderAdvance(double OrderAdvance) {
        this.OrderAdvance = OrderAdvance;
    }

    /**
     * @return the OrderFullPayment
     */
    public double getOrderFullPayment() {
        return OrderFullPayment;
    }

    /**
     * @param OrderFullPayment the OrderFullPayment to set
     */
    public void setOrderFullPayment(double OrderFullPayment) {
        this.OrderFullPayment = OrderFullPayment;
    }

    
}
