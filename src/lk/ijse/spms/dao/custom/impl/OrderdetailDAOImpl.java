/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.spms.dao.CrudUtil;
import lk.ijse.spms.dao.custom.OrderdetailDAO;
import lk.ijse.spms.entity.OrderDetail;

/**
 *
 * @author User
 */
public class OrderdetailDAOImpl implements OrderdetailDAO{

    @Override
    public boolean add(OrderDetail entity) throws Exception {
       return CrudUtil.executeUpdate("Insert into orderdetail values(?,?,?,?,?)", entity.getOrderDetailID(), entity.getOrderID_FK(),entity.getPID_FK(),entity.getOrderQTY(),entity.getUnitPrise());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("delete from orderdetail where OrderDeatilID=?",id);
    }

    @Override
    public boolean update(OrderDetail entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderDetail search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrderDetail> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
