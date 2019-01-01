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
public class SuplierOrderPaymentDTO {
    private String pid;
    private String soid;
    private String date;
    private double advance;
    private double fullPayment;

    public SuplierOrderPaymentDTO() {
    }

    public SuplierOrderPaymentDTO(String pid, String soid, String date, double advance, double fullPayment) {
        this.pid = pid;
        this.soid = soid;
        this.date = date;
        this.advance = advance;
        this.fullPayment = fullPayment;
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
     * @return the soid
     */
    public String getSoid() {
        return soid;
    }

    /**
     * @param soid the soid to set
     */
    public void setSoid(String soid) {
        this.soid = soid;
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
