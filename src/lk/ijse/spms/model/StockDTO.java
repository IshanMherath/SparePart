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
public class StockDTO {
    private String Stock_Id; 
    private String pid;  
    private String soId;
    private int qty; 
    private double amount;

    public StockDTO() {
    }

    public StockDTO(String Stock_Id, String pid, String soId, int qty, double amount) {
        this.Stock_Id = Stock_Id;
        this.pid = pid;
        this.soId = soId;
        this.qty = qty;
        this.amount = amount;
    }

    /**
     * @return the Stock_Id
     */
    public String getStock_Id() {
        return Stock_Id;
    }

    /**
     * @param Stock_Id the Stock_Id to set
     */
    public void setStock_Id(String Stock_Id) {
        this.Stock_Id = Stock_Id;
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
     * @return the soId
     */
    public String getSoId() {
        return soId;
    }

    /**
     * @param soId the soId to set
     */
    public void setSoId(String soId) {
        this.soId = soId;
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
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    
}
