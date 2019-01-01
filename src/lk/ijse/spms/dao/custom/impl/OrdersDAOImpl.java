/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.dao.custom.impl;

import java.sql.Array;
import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.spms.dao.CrudUtil;
import lk.ijse.spms.dao.custom.OrdersDAO;
import lk.ijse.spms.entity.Orders;

/**
 *
 * @author User
 */
public class OrdersDAOImpl implements OrdersDAO{

    @Override
    public boolean add(Orders entity) throws Exception {
        return CrudUtil.executeUpdate("Insert into Orders values(?,?,?,?)",entity.getOrderID_PK(),entity.getCust_id_FK(),entity.getDate(),entity.getAdvance());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE From Orders where OrderID=?", id);
    }

    @Override
    public boolean update(Orders entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Orders search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Orders> getAll() throws Exception {
        ArrayList<Orders> orderList=new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from Orders");
        while(rst.next()){
            orderList.add(new Orders(rst.getString(1),rst.getString(1),rst.getString(3),rst.getDouble(4)));
        }
        return orderList;
    }
    
}
