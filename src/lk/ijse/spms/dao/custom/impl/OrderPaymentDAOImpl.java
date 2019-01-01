/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.spms.dao.CrudUtil;
import lk.ijse.spms.dao.CrudeDAO;
import lk.ijse.spms.dao.custom.OrderPaymentDAO;
import lk.ijse.spms.entity.OrderPayment;

/**
 *
 * @author User
 */
public class OrderPaymentDAOImpl implements OrderPaymentDAO{

    @Override
    public boolean add(OrderPayment entity) throws Exception {
       return CrudUtil.executeUpdate("Insert Into orderpayment Values(?,?,?,?,?)", entity.getOpId(),entity.getOrderId(),entity.getDate(),entity.getAdvance(),entity.getFullPayment());
    }

    @Override
    public boolean delete(String id) throws Exception {
    return  CrudUtil.executeUpdate("Delete from orderpayment where OPID=?", id);
    }

    @Override
    public boolean update(OrderPayment entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderPayment search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrderPayment> getAll() throws Exception {
        ArrayList<OrderPayment> getAllPayment=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select * from orderpayment");
        while(rst.next()){
            getAllPayment.add(new OrderPayment(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4),rst.getDouble(5)));
        }
        return getAllPayment;            
    }
}
