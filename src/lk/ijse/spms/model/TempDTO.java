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
public class TempDTO {
    private String orderId;
    private String partId;
    private int qty;
    private double unitPrice;

    public TempDTO() {
    }

    public TempDTO(String orderId, String partId, int qty, double unitPrice) {
        this.orderId = orderId;
        this.partId = partId;
        this.qty = qty;
        this.unitPrice = unitPrice;
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
     * @return the partId
     */
    public String getPartId() {
        return partId;
    }

    /**
     * @param partId the partId to set
     */
    public void setPartId(String partId) {
        this.partId = partId;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

   
    
}
