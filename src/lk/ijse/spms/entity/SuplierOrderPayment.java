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
public class SuplierOrderPayment {
 private String pid_PK;       
 private String soid_FK;       
 private String date;        
 private double advance;     
 private double fullpayment;

    public SuplierOrderPayment() {
    }

    public SuplierOrderPayment(String pid_PK, String soid_FK, String date, double advance, double fullpayment) {
        this.pid_PK = pid_PK;
        this.soid_FK = soid_FK;
        this.date = date;
        this.advance = advance;
        this.fullpayment = fullpayment;
    }

    /**
     * @return the pid_PK
     */
    public String getPid_PK() {
        return pid_PK;
    }

    /**
     * @param pid_PK the pid_PK to set
     */
    public void setPid_PK(String pid_PK) {
        this.pid_PK = pid_PK;
    }

    /**
     * @return the soid_FK
     */
    public String getSoid_FK() {
        return soid_FK;
    }

    /**
     * @param soid_FK the soid_FK to set
     */
    public void setSoid_FK(String soid_FK) {
        this.soid_FK = soid_FK;
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
     * @return the fullpayment
     */
    public double getFullpayment() {
        return fullpayment;
    }

    /**
     * @param fullpayment the fullpayment to set
     */
    public void setFullpayment(double fullpayment) {
        this.fullpayment = fullpayment;
    }
 
}
