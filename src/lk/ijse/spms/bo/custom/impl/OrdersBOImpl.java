/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.spms.bo.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.spms.bo.custom.OrdersBO;
import lk.ijse.spms.dao.DAOFactory;
import lk.ijse.spms.dao.SuperDAO;
import lk.ijse.spms.dao.custom.OrdersDAO;
import lk.ijse.spms.db.DBConnection;
import lk.ijse.spms.entity.Orders;
import lk.ijse.spms.model.OrdersDTO;

/**
 *
 * @author User
 */
public class OrdersBOImpl implements OrdersBO{
    OrdersDAO superDAO;

    public OrdersBOImpl() throws Exception {
         superDAO = (OrdersDAO) DAOFactory.getDAOFactory().getSuperDAO(DAOFactory.DAOFactypes.ORDERS);
    }
    
    @Override
    public boolean addOrders(OrdersDTO dTO) throws Exception {
        return superDAO.add(new Orders(dTO.getOrderID(),dTO.getCust_id(),dTO.getDate(),dTO.getAdvance()));
     
    }

    @Override
    public boolean deleteOrders(String id) throws Exception {
        return superDAO.delete(id);
    }    

    @Override
    public ArrayList<String> getAllOrdersIds() throws Exception {
        ArrayList<Orders> all = superDAO.getAll();
        ArrayList<String> newArry=new ArrayList<>();
        for (Orders orders : all) {
            newArry.add(orders.getOrderID_PK());
            
        }
          return newArry;
    }

    @Override
    public ArrayList<OrdersDTO> getAllOrders() throws Exception {
        ArrayList<Orders> all = superDAO.getAll();
        ArrayList<OrdersDTO> getOrderList=new ArrayList<>();
        for (Orders orders : all) {
           getOrderList.add(new OrdersDTO(orders.getOrderID_PK(), orders.getCust_id_FK(),orders.getDate(),orders.getAdvance()));
            
        }
        return getOrderList;
    }
}
