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
public class Parts extends Super {

    private String PID;
    private String PART_NAME;
    private String Description;
    private String VEHICLE_TYPE;
    private String MODEL;
    private String CATOCORY;
    private String TYPE;
    private int QTY;
    private double UnitPrice;

    public Parts() {
    }

    public Parts(String PID, String PART_NAME, String Description, String VEHICLE_TYPE, String MODEL, String CATOCORY, String TYPE, int QTY, double UnitPrice) {
        this.PID = PID;
        this.PART_NAME = PART_NAME;
        this.Description = Description;
        this.VEHICLE_TYPE = VEHICLE_TYPE;
        this.MODEL = MODEL;
        this.CATOCORY = CATOCORY;
        this.TYPE = TYPE;
        this.QTY = QTY;
        this.UnitPrice = UnitPrice;
    }

    /**
     * @return the PID
     */
    public String getPID() {
        return PID;
    }

    /**
     * @param PID the PID to set
     */
    public void setPID(String PID) {
        this.PID = PID;
    }

    /**
     * @return the PART_NAME
     */
    public String getPART_NAME() {
        return PART_NAME;
    }

    /**
     * @param PART_NAME the PART_NAME to set
     */
    public void setPART_NAME(String PART_NAME) {
        this.PART_NAME = PART_NAME;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the VEHICLE_TYPE
     */
    public String getVEHICLE_TYPE() {
        return VEHICLE_TYPE;
    }

    /**
     * @param VEHICLE_TYPE the VEHICLE_TYPE to set
     */
    public void setVEHICLE_TYPE(String VEHICLE_TYPE) {
        this.VEHICLE_TYPE = VEHICLE_TYPE;
    }

    /**
     * @return the MODEL
     */
    public String getMODEL() {
        return MODEL;
    }

    /**
     * @param MODEL the MODEL to set
     */
    public void setMODEL(String MODEL) {
        this.MODEL = MODEL;
    }

    /**
     * @return the CATOCORY
     */
    public String getCATOCORY() {
        return CATOCORY;
    }

    /**
     * @param CATOCORY the CATOCORY to set
     */
    public void setCATOCORY(String CATOCORY) {
        this.CATOCORY = CATOCORY;
    }

    /**
     * @return the TYPE
     */
    public String getTYPE() {
        return TYPE;
    }

    /**
     * @param TYPE the TYPE to set
     */
    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    /**
     * @return the QTY
     */
    public int getQTY() {
        return QTY;
    }

    /**
     * @param QTY the QTY to set
     */
    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    /**
     * @return the UnitPrice
     */
    public double getUnitPrice() {
        return UnitPrice;
    }

    /**
     * @param UnitPrice the UnitPrice to set
     */
    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

}
