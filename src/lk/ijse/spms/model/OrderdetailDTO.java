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
public class OrderdetailDTO{
 private String orderDetailID;
 private String orderId;
 private String pid;
 private int orderQty;
 private double unitPrise;

    public OrderdetailDTO() {
    }

    public OrderdetailDTO(String orderDetailID, String orderId, String pid, int orderQty, double unitPrise) {
        this.orderDetailID = orderDetailID;
        this.orderId = orderId;
        this.pid = pid;
        this.orderQty = orderQty;
        this.unitPrise = unitPrise;
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
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @return the orderQty
     */
    public int getOrderQty() {
        return orderQty;
    }

    /**
     * @param orderQty the orderQty to set
     */
    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    /**
     * @return the unitPrise
     */
    public double getUnitPrise() {
        return unitPrise;
    }

    /**
     * @param unitPrise the unitPrise to set
     */
    public void setUnitPrise(double unitPrise) {
        this.unitPrise = unitPrise;
    }

    /**
     * @return the orderDetailID
     */
    public String getOrderDetailID() {
        return orderDetailID;
    }

    /**
     * @param orderDetailID the orderDetailID to set
     */
    public void setOrderDetailID(String orderDetailID) {
        this.orderDetailID = orderDetailID;
    }
 
 
}
