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
public class Orders {
 private String orderID_PK; 
 private String cust_id_FK; 
 private String date;    
 private double advance;

    public Orders() {
    }

    public Orders(String orderID_PK, String cust_id_FK, String date, double advance) {
        this.orderID_PK = orderID_PK;
        this.cust_id_FK = cust_id_FK;
        this.date = date;
        this.advance = advance;
    }

    /**
     * @return the orderID_PK
     */
    public String getOrderID_PK() {
        return orderID_PK;
    }

    /**
     * @param orderID_PK the orderID_PK to set
     */
    public void setOrderID_PK(String orderID_PK) {
        this.orderID_PK = orderID_PK;
    }

    /**
     * @return the cust_id_FK
     */
    public String getCust_id_FK() {
        return cust_id_FK;
    }

    /**
     * @param cust_id_FK the cust_id_FK to set
     */
    public void setCust_id_FK(String cust_id_FK) {
        this.cust_id_FK = cust_id_FK;
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
 
 
}
