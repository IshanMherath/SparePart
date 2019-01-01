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
public class OrderDetail {
    private String OrderDetailID;
    private String OrderID_FK; 
    private String PID_FK;       
    private int OrderQTY;  
    private double UnitPrise;

    public OrderDetail() {
    }

    public OrderDetail(String OrderDetailID, String OrderID_FK, String PID_FK, int OrderQTY, double UnitPrise) {
        this.OrderDetailID = OrderDetailID;
        this.OrderID_FK = OrderID_FK;
        this.PID_FK = PID_FK;
        this.OrderQTY = OrderQTY;
        this.UnitPrise = UnitPrise;
    }

    /**
     * @return the OrderDetailID
     */
    public String getOrderDetailID() {
        return OrderDetailID;
    }

    /**
     * @param OrderDetailID the OrderDetailID to set
     */
    public void setOrderDetailID(String OrderDetailID) {
        this.OrderDetailID = OrderDetailID;
    }

    /**
     * @return the OrderID_FK
     */
    public String getOrderID_FK() {
        return OrderID_FK;
    }

    /**
     * @param OrderID_FK the OrderID_FK to set
     */
    public void setOrderID_FK(String OrderID_FK) {
        this.OrderID_FK = OrderID_FK;
    }

    /**
     * @return the PID_FK
     */
    public String getPID_FK() {
        return PID_FK;
    }

    /**
     * @param PID_FK the PID_FK to set
     */
    public void setPID_FK(String PID_FK) {
        this.PID_FK = PID_FK;
    }

    /**
     * @return the OrderQTY
     */
    public int getOrderQTY() {
        return OrderQTY;
    }

    /**
     * @param OrderQTY the OrderQTY to set
     */
    public void setOrderQTY(int OrderQTY) {
        this.OrderQTY = OrderQTY;
    }

    /**
     * @return the UnitPrise
     */
    public double getUnitPrise() {
        return UnitPrise;
    }

    /**
     * @param UnitPrise the UnitPrise to set
     */
    public void setUnitPrise(double UnitPrise) {
        this.UnitPrise = UnitPrise;
    }

    

}
