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
public class Suplier{
  private String sup_Id_PK;   
  private String sup_Name;  
  private String address;  
  private String company;  
  private String teliPhone;
  private String email; 

    public Suplier() {
    }

    public Suplier(String sup_Id_PK, String sup_Name, String address, String company, String teliPhone, String email) {
        this.sup_Id_PK = sup_Id_PK;
        this.sup_Name = sup_Name;
        this.address = address;
        this.company = company;
        this.teliPhone = teliPhone;
        this.email = email;
    }

    /**
     * @return the sup_Id_PK
     */
    public String getSup_Id_PK() {
        return sup_Id_PK;
    }

    /**
     * @param sup_Id_PK the sup_Id_PK to set
     */
    public void setSup_Id_PK(String sup_Id_PK) {
        this.sup_Id_PK = sup_Id_PK;
    }

    /**
     * @return the sup_Name
     */
    public String getSup_Name() {
        return sup_Name;
    }

    /**
     * @param sup_Name the sup_Name to set
     */
    public void setSup_Name(String sup_Name) {
        this.sup_Name = sup_Name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the teliPhone
     */
    public String getTeliPhone() {
        return teliPhone;
    }

    /**
     * @param teliPhone the teliPhone to set
     */
    public void setTeliPhone(String teliPhone) {
        this.teliPhone = teliPhone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
}
