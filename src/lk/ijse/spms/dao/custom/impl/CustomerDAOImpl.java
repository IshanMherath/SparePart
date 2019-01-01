/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.spms.dao.CrudUtil;
import lk.ijse.spms.dao.custom.CustomerDAO;
import lk.ijse.spms.entity.Customer;
import lk.ijse.spms.entity.Super;

/**
 *
 * @author User
 */
public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public boolean add(Customer entity) throws Exception {
       return CrudUtil.executeUpdate("Insert Into Customer Values(?,?,?,?,?,?,?)",entity.getCust_id(),entity.getFname(),entity.getLname(),entity.getNIC(),entity.getAddress(),entity.getTelephone_num(),entity.getCust_Email());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE From customer where Cust_id=?", id);
    }

    @Override
    public boolean update(Customer entity) throws Exception {
    return CrudUtil.executeUpdate("Update Customer set Fname=?,Lname=?,NIC=?,address=?,telephone_num=?,cust_Email=? where Cust_id=?",entity.getFname(),entity.getLname(),entity.getNIC(),entity.getAddress(),entity.getTelephone_num(),entity.getCust_Email(),entity.getCust_id());
    }
    @Override
    public Customer search(String id) throws Exception {
        Customer cus=null;
        ResultSet Query = CrudUtil.executeQuery("Select * from customer where Cust_id=?",id);
        while(Query.next()){
            cus=new Customer(Query.getString("Cust_id"),Query.getString("Fname"),Query.getString("Lname"),Query.getString("NIC"),Query.getString("address"),Query.getString("telephone_num"),Query.getString("cust_Email"));
        }
        return cus;
  }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        ArrayList<Customer> customerList=new ArrayList<>();
        ResultSet query = CrudUtil.executeQuery("Select * from customer");
        while(query.next()){
            customerList.add(new Customer(query.getString(1),query.getString(2),query.getString(3),query.getString(4),query.getString(5),query.getString(6),query.getString(7)));
        }
        return customerList;
    }

   
    
    
    
    
    
}
    
    
    
    
    
    
    
    
    /* @Override
    public boolean add(Super ext) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    @Override
    public Super search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Super ext) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
    
   

