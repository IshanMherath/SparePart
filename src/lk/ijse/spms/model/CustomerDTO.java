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
public class CustomerDTO {
    private String Cust_id;    
    private String Fname;    
    private String Lname;    
    private String NIC;        
    private String address;      
    private String telephone_num; 
    private String cust_Email;

    public CustomerDTO() {
    }

    public CustomerDTO(String Cust_id, String Fname, String Lname, String NIC, String address, String telephone_num, String cust_Email) {
        this.Cust_id = Cust_id;
        this.Fname = Fname;
        this.Lname = Lname;
        this.NIC = NIC;
        this.address = address;
        this.telephone_num = telephone_num;
        this.cust_Email = cust_Email;
    }

    /**
     * @return the Cust_id
     */
    public String getCust_id() {
        return Cust_id;
    }

    /**
     * @param Cust_id the Cust_id to set
     */
    public void setCust_id(String Cust_id) {
        this.Cust_id = Cust_id;
    }

    /**
     * @return the Fname
     */
    public String getFname() {
        return Fname;
    }

    /**
     * @param Fname the Fname to set
     */
    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    /**
     * @return the Lname
     */
    public String getLname() {
        return Lname;
    }

    /**
     * @param Lname the Lname to set
     */
    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    /**
     * @return the NIC
     */
    public String getNIC() {
        return NIC;
    }

    /**
     * @param NIC the NIC to set
     */
    public void setNIC(String NIC) {
        this.NIC = NIC;
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
     * @return the telephone_num
     */
    public String getTelephone_num() {
        return telephone_num;
    }

    /**
     * @param telephone_num the telephone_num to set
     */
    public void setTelephone_num(String telephone_num) {
        this.telephone_num = telephone_num;
    }

    /**
     * @return the cust_Email
     */
    public String getCust_Email() {
        return cust_Email;
    }

    /**
     * @param cust_Email the cust_Email to set
     */
    public void setCust_Email(String cust_Email) {
        this.cust_Email = cust_Email;
    }
    
   
}
