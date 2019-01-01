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
public class PartsDTO  {

    private String id;
    private String partName;
    private String Description;
    private String vehicleType;
    private String model;
    private String catocory;
    private String type;
    private int qty;
    private double unitPrise;

    public PartsDTO() {
    }

    public PartsDTO(String id, String partName, String Description, String vehicleType, String model, String catocory, String type, int qty, double unitPrise) {
        this.id = id;
        this.partName = partName;
        this.Description = Description;
        this.vehicleType = vehicleType;
        this.model = model;
        this.catocory = catocory;
        this.type = type;
        this.qty = qty;
        this.unitPrise = unitPrise;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the partName
     */
    public String getPartName() {
        return partName;
    }

    /**
     * @param partName the partName to set
     */
    public void setPartName(String partName) {
        this.partName = partName;
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
     * @return the vehicleType
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * @param vehicleType the vehicleType to set
     */
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the catocory
     */
    public String getCatocory() {
        return catocory;
    }

    /**
     * @param catocory the catocory to set
     */
    public void setCatocory(String catocory) {
        this.catocory = catocory;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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

}
