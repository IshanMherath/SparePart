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
public class SuplierOrder extends Super{
    private String soId;  
    private String sup_Id;  
    private String part_Id; 
    private int qty;     
    private double amount;

    public SuplierOrder() {
    }

    public SuplierOrder(String soId, String sup_Id, String part_Id, int qty, double amount) {
        this.soId = soId;
        this.sup_Id = sup_Id;
        this.part_Id = part_Id;
        this.qty = qty;
        this.amount = amount;
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
     * @return the sup_Id
     */
    public String getSup_Id() {
        return sup_Id;
    }

    /**
     * @param sup_Id the sup_Id to set
     */
    public void setSup_Id(String sup_Id) {
        this.sup_Id = sup_Id;
    }

    /**
     * @return the part_Id
     */
    public String getPart_Id() {
        return part_Id;
    }

    /**
     * @param part_Id the part_Id to set
     */
    public void setPart_Id(String part_Id) {
        this.part_Id = part_Id;
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
