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
public class SuplierDTO {
        private String sup_Id;   
        private String sup_Name;  
        private String address;  
        private String company;  
        private String teliPhone;
        private String email; 

  public SuplierDTO() {
    }

    public SuplierDTO(String sup_Id, String sup_Name, String address, String company, String teliPhone, String email) {
        this.sup_Id = sup_Id;
        this.sup_Name = sup_Name;
        this.address = address;
        this.company = company;
        this.teliPhone = teliPhone;
        this.email = email;
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
